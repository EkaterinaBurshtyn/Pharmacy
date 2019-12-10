package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.ModeOfApplicationDto;
import org.burshtyn.pharmacy.entity.ModeOfApplication;
import org.springframework.stereotype.Service;

@Service
public class ModeOfApplicationDtoMapper implements BaseDtoMapper<ModeOfApplicationDto, ModeOfApplication> {

    @Override
    public ModeOfApplicationDto mapToDto(ModeOfApplication entity) {
        if (entity== null) {
            return null;
        }
        ModeOfApplicationDto dto = new ModeOfApplicationDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public ModeOfApplication mapToEntity(ModeOfApplicationDto dto) {
        if (dto== null) {
            return null;
        }
        ModeOfApplication entity = new ModeOfApplication();
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
