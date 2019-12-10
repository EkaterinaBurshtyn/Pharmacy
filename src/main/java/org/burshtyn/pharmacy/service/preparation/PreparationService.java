package org.burshtyn.pharmacy.service.preparation;

import org.burshtyn.pharmacy.entity.*;
import org.burshtyn.pharmacy.repository.PreparationRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.burshtyn.pharmacy.service.availability.AvailabilityService;
import org.burshtyn.pharmacy.service.sold.SoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PreparationService extends BaseServiceImpl<Preparation, PreparationRepository> {

    @Autowired
    private PreparationRepository repository;

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private SoldService soldService;

    @Override
    protected PreparationRepository getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Preparation> optionalPreparation = findOne(id);
        if (optionalPreparation.isPresent()) {
            Preparation preparation = optionalPreparation.get();

            List<Availability> availabilityList = availabilityService.findByPreparation(preparation);
            for (Availability availability : availabilityList) {
                availabilityService.delete(availability);
            }

            List<Sold> soldList = soldService.findByPreparation(preparation);
            for (Sold sold : soldList) {
                soldService.delete(sold);
            }

            super.delete(id);
        }
    }

    public Preparation create(PreparationGroup preparationGroup, String name, List<ModeOfApplication> modeOfApplicationList, PackageType packageType, List<State> indicationList, List<State> contraindicationList, List<StructureSubstance> structureSubstanceList) {
        Preparation entity = new Preparation();
        fillEntity(entity,
                preparationGroup,
                name,
                modeOfApplicationList,
                packageType,
                indicationList,
                contraindicationList,
                structureSubstanceList);

        if (entity.getPreparationGroup() == null || entity.getPackageType() == null) {
            return null;
        }

        return save(entity);
    }

    public Preparation update(Long id, PreparationGroup preparationGroup, String name, List<ModeOfApplication> modeOfApplicationList, PackageType packageType, List<State> indicationList, List<State> contraindicationList, List<StructureSubstance> structureSubstanceList) {
        Optional<Preparation> optional = findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        Preparation entity = optional.get();

        fillEntity(entity,
                preparationGroup,
                name,
                modeOfApplicationList,
                packageType,
                indicationList,
                contraindicationList,
                structureSubstanceList);

        if (entity.getPreparationGroup() == null || entity.getPackageType() == null) {
            return null;
        }

        return save(entity);
    }

    private void fillEntity(Preparation entity, PreparationGroup preparationGroup, String name, List<ModeOfApplication> modeOfApplicationList, PackageType packageType, List<State> indicationList, List<State> contraindicationList, List<StructureSubstance> structureSubstanceList) {
        entity.setPreparationGroup(preparationGroup);
        entity.setName(name);
        entity.setModesOfApplication(modeOfApplicationList);
        entity.setPackageType(packageType);
        entity.setIndications(indicationList);
        entity.setContraindications(contraindicationList);
        entity.setStructureSubstances(structureSubstanceList);
    }
}
