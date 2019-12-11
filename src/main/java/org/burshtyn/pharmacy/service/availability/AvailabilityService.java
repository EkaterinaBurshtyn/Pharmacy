package org.burshtyn.pharmacy.service.availability;

import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.entity.Preparation;
import org.burshtyn.pharmacy.repository.AvailabilityRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.burshtyn.pharmacy.service.preparation.PreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService extends BaseServiceImpl<Availability, AvailabilityRepository> {

    @Autowired
    private PreparationService preparationService;
    @Autowired
    private AvailabilityRepository repository;

    @Override
    protected AvailabilityRepository getRepository() {
        return repository;
    }

    public Availability findByPreparation(Preparation preparation) {
        List<Availability> availabilityList = repository.findByPreparation(preparation);
        if (availabilityList != null && availabilityList.size() == 1) {
            return availabilityList.get(0);
        }
        return null;
    }

    public Availability findByPreparationId(Long id) {
        Preparation preparation = preparationService
                .findOne(id)
                .orElse(null);
        if (preparation != null) {
            List<Availability> availabilityList = repository.findByPreparation(preparation);
            if (availabilityList != null && availabilityList.size() == 1) {
                return availabilityList.get(0);
            }
        }
        return null;
    }

    public Availability create(Long preparationId, Double quantity) {
        Availability entity = new Availability();
        fillEntity(entity, preparationId, quantity);

        if (entity.getPreparation() == null) {
            return null;
        }

        return save(entity);
    }

    public Availability update(Long id, Long preparationId, Double quantity) {
        Optional<Availability> optional = findOne(id);

        if (!optional.isPresent()) {
            return null;
        }

        Availability entity = optional.get();
        fillEntity(entity, preparationId, quantity);

        if (entity.getPreparation() == null) {
            return null;
        }

        return save(entity);
    }

    public Availability updateAvailabilityQuantity(Preparation preparation, Double oldSoldQuantity, Double newSoldQuantity) {
        Availability availability = findByPreparation(preparation);
        if (availability != null) {
            availability.setQuantity(availability.getQuantity() + oldSoldQuantity);
            return setNewAvailabilityQuantity(newSoldQuantity, availability);
        }
        return null;
    }

    public Availability decreaseAvailability(Preparation preparation, Double soldQuantity) {
        return updateAvailabilityQuantity(preparation, (double) 0, soldQuantity);
    }

    public Availability increaseAvailability(Preparation preparation, Double oldSoldQuantity) {
        return updateAvailabilityQuantity(preparation, oldSoldQuantity, (double) 0);
    }

    private Availability setNewAvailabilityQuantity(Double newSoldQuantity, Availability availability) {
        if (availability.getQuantity().compareTo(newSoldQuantity) < 0) {
            return null;
        }
        if (newSoldQuantity != 0) {
            availability.setQuantity(availability.getQuantity() - newSoldQuantity);
        }

        return save(availability);
    }

    private void fillEntity(Availability entity, Long preparationId, Double quantity) {
        entity.setPreparation(
                preparationService
                        .findOne(preparationId)
                        .orElse(null));
        entity.setQuantity(quantity);
    }
}
