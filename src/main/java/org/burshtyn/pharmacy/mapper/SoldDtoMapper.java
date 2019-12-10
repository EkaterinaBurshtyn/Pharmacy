package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.sold.SoldDto;
import org.burshtyn.pharmacy.entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldDtoMapper implements BaseDtoMapper<SoldDto, Sold> {

    @Autowired
    private PreparationDtoMapper preparationDtoMapper;

    @Override
    public SoldDto mapToDto(Sold entity) {
        if (entity== null) {
            return null;
        }
        SoldDto dto = new SoldDto();
        dto.setId(entity.getId());
        dto.setPreparation(preparationDtoMapper.mapToDto(entity.getPreparation()));
        dto.setQuantity(entity.getQuantity());
        dto.setPricePerPack(entity.getPricePerPack());
        return dto;
    }

    /**
     * Don't remove this method.
     * It has been created only for compatibility.
     */
    @Override
    public Sold mapToEntity(SoldDto dto) {
        return null;
    }

}
