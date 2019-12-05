package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.SoldDto;
import org.burshtyn.pharmacy.entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldDtoMapper implements BaseDtoMapper<SoldDto, Sold> {

    @Autowired
    private PreparationDtoMapper preparationDtoMapper;

    @Override
    public SoldDto mapToDto(Sold entity) {
        SoldDto dto = new SoldDto();
        dto.setId(entity.getId());
        dto.setPreparation(preparationDtoMapper.mapToDto(entity.getPreparation()));
        dto.setQuantity(entity.getQuantity());
        dto.setPricePerPack(entity.getPricePerPack());
        return dto;
    }

    @Override
    public Sold mapToEntity(SoldDto dto) {
        Sold entity = new Sold();
        entity.setQuantity(dto.getQuantity());
        entity.setPricePerPack(dto.getPricePerPack());
        return entity;
    }

}
