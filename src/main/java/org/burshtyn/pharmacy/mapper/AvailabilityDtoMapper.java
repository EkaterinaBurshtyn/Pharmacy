package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.availability.AvailabilityDto;
import org.burshtyn.pharmacy.entity.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityDtoMapper implements BaseDtoMapper<AvailabilityDto, Availability> {

    @Autowired
    private PreparationDtoMapper preparationDtoMapper;

    @Override
    public AvailabilityDto mapToDto(Availability entity) {
        if (entity== null) {
            return null;
        }
        AvailabilityDto dto = new AvailabilityDto();
        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setPreparation(preparationDtoMapper.mapToDto(entity.getPreparation()));
        return dto;
    }

    /**
     * Don't remove this method.
     * It has been created only for compatibility.
     */
    @Override
    public Availability mapToEntity(AvailabilityDto dto) {
        return null;
    }
}
