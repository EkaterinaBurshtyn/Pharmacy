package org.burshtyn.pharmacy.service.sold;

import org.burshtyn.pharmacy.dto.sold.SoldPersistDto;
import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.entity.Preparation;
import org.burshtyn.pharmacy.entity.Sold;
import org.burshtyn.pharmacy.service.availability.AvailabilityService;
import org.burshtyn.pharmacy.service.preparation.PreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldPersistService {

    @Autowired
    private PreparationService preparationService;

    @Autowired
    private AvailabilityService availabilityService;

    public Sold create(SoldPersistDto dto) {
        Preparation preparation = preparationService
                .findOne(dto.getPreparationId())
                .orElse(null);

        if (preparation != null) {
            Availability availability = availabilityService.decreaseAvailability(preparation, dto.getQuantity());
            if (availability != null) {
                return createEntity(preparation, dto);
            }
        }
        return null;
    }

    public Sold update(Double oldSoldQuantity, SoldPersistDto dto) {
        Preparation preparation = preparationService
                .findOne(dto.getPreparationId())
                .orElse(null);

        if (preparation != null) {
            Availability availability = availabilityService.updateAvailabilityQuantity(preparation, oldSoldQuantity, dto.getQuantity());
            if (availability != null) {
                return createEntity(preparation, dto);
            }
        }
        return null;
    }

    public void increaseAvailability (Sold sold) {
        Preparation preparation = sold.getPreparation();
        if (preparation != null) {
            availabilityService.increaseAvailability(preparation, sold.getQuantity());
        }
    }

    private Sold createEntity(Preparation preparation, SoldPersistDto dto) {
        Sold entity = new Sold();
        entity.setPreparation(preparation);
        entity.setQuantity(dto.getQuantity());
        entity.setPricePerPack(dto.getPricePerPack());
        return entity;
    }

}
