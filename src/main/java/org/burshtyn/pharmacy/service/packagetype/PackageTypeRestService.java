package org.burshtyn.pharmacy.service.packagetype;

import org.burshtyn.pharmacy.dto.ModeOfApplicationDto;
import org.burshtyn.pharmacy.dto.PackageTypeDto;
import org.burshtyn.pharmacy.entity.PackageType;
import org.burshtyn.pharmacy.mapper.PackageTypeDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackageTypeRestService {

    @Autowired
    private PackageTypeService service;
    @Autowired
    private PackageTypeDtoMapper dtoMapper;

    public PackageTypeDto getOne(Long id) {
        Optional<PackageType> optionalPackageType = service.findOne(id);
        if (!optionalPackageType.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optionalPackageType.get());

    }

    public PackageTypeDto create(PackageTypeDto packageTypeDto) {
        PackageType inEntity = dtoMapper.mapToEntity(packageTypeDto);
        PackageType savedEntity = service.save(inEntity);
        return dtoMapper.mapToDto(savedEntity);
    }

    public PackageTypeDto update(Long id, PackageTypeDto packageTypeDto) {
        Optional<PackageType> optionalPackageType = service.findOne(id);
        if (!optionalPackageType.isPresent()) {
            return null;
        }
        PackageType packageType = optionalPackageType.get();

        packageType.setName(packageTypeDto.getName());

        PackageType savedEntity = service.save(packageType);
        return dtoMapper.mapToDto(savedEntity);
    }

    public List<PackageTypeDto> getAll() {
        return service.findAll()
                .stream()
                .map(entity -> dtoMapper.mapToDto(entity)).collect(Collectors.toList());
    }

}
