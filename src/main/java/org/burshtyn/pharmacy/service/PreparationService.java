package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.entity.Preparation;
import org.burshtyn.pharmacy.entity.Sold;
import org.burshtyn.pharmacy.repository.PreparationRepository;
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
            for (Availability availability: availabilityList) {
                availabilityService.delete(availability);
            }

            List<Sold> soldList = soldService.findByPreparation(preparation);
            for (Sold sold: soldList) {
                soldService.delete(sold);
            }

            super.delete(id);
        }
    }

    @Override
    public void delete(Preparation entity) {
        super.delete(entity);
    }
}
