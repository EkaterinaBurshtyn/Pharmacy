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

    public List<Availability> findByPreparation(Preparation preparation) {
        return repository.findByPreparation(preparation);
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

    private void fillEntity(Availability entity, Long preparationId, Double quantity) {
        entity.setPreparation(
                preparationService
                        .findOne(preparationId)
                        .orElse(null));
        entity.setQuantity(quantity);
    }
}
