package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.PackageTypeDto;
import org.burshtyn.pharmacy.entity.PackageType;
import org.springframework.stereotype.Service;

@Service
public class PackageTypeDtoMapper implements BaseDtoMapper<PackageTypeDto, PackageType> {

    @Override
    public PackageTypeDto mapToDto(PackageType entity) {
        if (entity== null) {
            return null;
        }
        PackageTypeDto dto = new PackageTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public PackageType mapToEntity(PackageTypeDto dto) {
        if (dto== null) {
            return null;
        }
        PackageType entity = new PackageType();
        entity.setName(dto.getName());
        return entity;
    }
}
