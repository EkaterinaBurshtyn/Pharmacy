package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.StructureSubstanceDto;
import org.burshtyn.pharmacy.entity.StructureSubstance;
import org.springframework.stereotype.Service;

@Service
public class StructureSubstanceDtoMapper implements BaseDtoMapper<StructureSubstanceDto, StructureSubstance> {

    @Override
    public StructureSubstanceDto mapToDto(StructureSubstance entity) {
        if (entity== null) {
            return null;
        }
        StructureSubstanceDto dto = new StructureSubstanceDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public StructureSubstance mapToEntity(StructureSubstanceDto dto) {
        if (dto== null) {
            return null;
        }
        StructureSubstance entity = new StructureSubstance();
        entity.setName(dto.getName());
        return entity;
    }
}
