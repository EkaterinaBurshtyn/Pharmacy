package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.AvailabilityDto;
import org.burshtyn.pharmacy.entity.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityDtoMapper implements BaseDtoMapper<AvailabilityDto, Availability> {

    @Autowired
    private PreparationDtoMapper preparationDtoMapper;

    @Override
    public AvailabilityDto mapToDto(Availability entity) {
        AvailabilityDto dto = new AvailabilityDto();
        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setPreparation(preparationDtoMapper.mapToDto(entity.getPreparation()));
        return dto;
    }

    @Override
    public Availability mapToEntity(AvailabilityDto dto) {
        Availability entity = new Availability();
        entity.setQuantity(dto.getQuantity());
        return entity;
    }
}
