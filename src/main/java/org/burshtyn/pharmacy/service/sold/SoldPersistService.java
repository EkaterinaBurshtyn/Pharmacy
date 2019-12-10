package org.burshtyn.pharmacy.service.sold;

import org.burshtyn.pharmacy.dto.sold.SoldPersistDto;
import org.burshtyn.pharmacy.entity.Sold;
import org.burshtyn.pharmacy.service.preparation.PreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldPersistService {

    @Autowired
    private PreparationService preparationService;

    public Sold mapToEntity(SoldPersistDto dto) {
        Sold entity = new Sold();
        fillEntity(entity, dto);

        if (entity.getPreparation() == null) {
            return null;
        }

        return entity;
    }

    private void fillEntity(Sold entity, SoldPersistDto dto) {
        entity.setPreparation(
                preparationService
                        .findOne(dto.getPreparationId())
                        .orElse(null));
        entity.setQuantity(dto.getQuantity());
        entity.setPricePerPack(dto.getPricePerPack());
    }

}
