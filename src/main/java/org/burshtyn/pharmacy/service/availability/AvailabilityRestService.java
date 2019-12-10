package org.burshtyn.pharmacy.service.availability;

import org.burshtyn.pharmacy.dto.availability.AvailabilityDto;
import org.burshtyn.pharmacy.dto.availability.AvailabilityPersistDto;
import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.mapper.AvailabilityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvailabilityRestService {

    @Autowired
    private AvailabilityService service;
    @Autowired
    private AvailabilityDtoMapper dtoMapper;


    public AvailabilityDto getOne(Long id) {
        Optional<Availability> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public AvailabilityDto create(AvailabilityPersistDto dto) {
        return dtoMapper.mapToDto(service.create(dto.getPreparationId(), dto.getQuantity()));
    }

    public AvailabilityDto update(Long id, AvailabilityPersistDto dto) {
        Availability entity = service.update(id, dto.getPreparationId(), dto.getQuantity());
        return dtoMapper.mapToDto(entity);
    }

}
