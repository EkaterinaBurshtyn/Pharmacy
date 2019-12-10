package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.PreparationGroupDto;
import org.burshtyn.pharmacy.entity.PreparationGroup;
import org.springframework.stereotype.Service;

@Service
public class PreparationGroupDtoMapper implements BaseDtoMapper<PreparationGroupDto, PreparationGroup> {

    @Override
    public PreparationGroupDto mapToDto(PreparationGroup entity) {
        if (entity== null) {
            return null;
        }
        PreparationGroupDto dto = new PreparationGroupDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public PreparationGroup mapToEntity(PreparationGroupDto dto) {
        if (dto== null) {
            return null;
        }
        PreparationGroup entity = new PreparationGroup();
        entity.setName(dto.getName());
        return entity;
    }
}
