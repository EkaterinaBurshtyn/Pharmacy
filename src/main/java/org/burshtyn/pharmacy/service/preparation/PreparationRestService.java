package org.burshtyn.pharmacy.service.preparation;

import org.burshtyn.pharmacy.dto.preparation.PreparationDto;
import org.burshtyn.pharmacy.dto.preparation.PreparationPersistDto;
import org.burshtyn.pharmacy.entity.*;
import org.burshtyn.pharmacy.mapper.PreparationDtoMapper;
import org.burshtyn.pharmacy.service.modeofapplication.ModeOfApplicationService;
import org.burshtyn.pharmacy.service.preparationgroup.PreparationGroupService;
import org.burshtyn.pharmacy.service.state.StateService;
import org.burshtyn.pharmacy.service.structuresubstance.StructureSubstanceService;
import org.burshtyn.pharmacy.service.packagetype.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparationRestService {

    @Autowired
    private PreparationDtoMapper dtoMapper;
    @Autowired
    private PreparationService service;
    @Autowired
    private PreparationGroupService preparationGroupService;
    @Autowired
    private ModeOfApplicationService modeOfApplicationService;
    @Autowired
    private PackageTypeService packageTypeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private StructureSubstanceService structureSubstanceService;

    public PreparationDto getOne(Long id) {
        Optional<Preparation> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public PreparationDto create(PreparationPersistDto dto) {
        PreparationGroup preparationGroup = getPreparationGroup(dto.getPreparationGroupId());
        List<ModeOfApplication> modeOfApplicationList = getModesOfApplication(dto.getModeOfApplicationIds());
        PackageType packageType = getPackageType(dto.getPackageTypeId());
        List<State> indicationList = getStates(dto.getIndicationIds());
        List<State> contraindicationList = getStates(dto.getContraindicationIds());
        List<StructureSubstance> structureSubstanceList = getStructureSubstances(dto.getStructureSubstanceIds());

        Preparation preparation = service.create(
                preparationGroup,
                dto.getName(),
                modeOfApplicationList,
                packageType,
                indicationList,
                contraindicationList,
                structureSubstanceList);
        return dtoMapper.mapToDto(preparation);
    }

    public PreparationDto update(Long id, PreparationPersistDto dto) {
        PreparationGroup preparationGroup = getPreparationGroup(dto.getPreparationGroupId());
        List<ModeOfApplication> modeOfApplicationList = getModesOfApplication(dto.getModeOfApplicationIds());
        PackageType packageType = getPackageType(dto.getPackageTypeId());
        List<State> indicationList = getStates(dto.getIndicationIds());
        List<State> contraindicationList = getStates(dto.getContraindicationIds());
        List<StructureSubstance> structureSubstanceList = getStructureSubstances(dto.getStructureSubstanceIds());

        Preparation preparation = service.update(
                id,
                preparationGroup,
                dto.getName(),
                modeOfApplicationList,
                packageType,
                indicationList,
                contraindicationList,
                structureSubstanceList);
        return dtoMapper.mapToDto(preparation);
    }

    public void delete(Long id) {
        service.delete(id);
    }

    private PreparationGroup getPreparationGroup(Long id) {
        return preparationGroupService
                .findOne(id)
                .orElse(null);
    }

    private List<ModeOfApplication> getModesOfApplication(List<Long> idList) {
        return modeOfApplicationService.findAllById(idList);
    }

    private PackageType getPackageType(Long id) {
        return packageTypeService
                .findOne(id)
                .orElse(null);
    }

    private List<State> getStates(List<Long> ids) {
        return stateService.findAllById(ids);
    }

    private List<StructureSubstance> getStructureSubstances(List<Long> ids) {
        return structureSubstanceService.findAllById(ids);
    }

}
