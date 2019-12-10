package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.PackageTypeDto;
import org.burshtyn.pharmacy.entity.PackageType;
import org.burshtyn.pharmacy.mapper.PackageTypeDtoMapper;
import org.burshtyn.pharmacy.service.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Api(tags = {"Package-type"})
@SwaggerDefinition(tags = {
        @Tag(name = "Package-type", description = "Package-type REST API")
})
@RestController
public class PackageTypeController {

    @Autowired
    private PackageTypeDtoMapper packageTypeDtoMapper;

    @Autowired
    private PackageTypeService packageTypeService;

    @ApiOperation(value = "View a package type")
    @GetMapping("/package type/{id}")
    public PackageTypeDto get(
            @ApiParam(value = "Package type id", required = true)
            @PathVariable("id") Long id) {
        Optional<PackageType> optionalPackageType = packageTypeService.findOne(id);
        if (optionalPackageType.isPresent()) {
            return packageTypeDtoMapper.mapToDto(optionalPackageType.get());
        }
        return null;
    }


    @ApiOperation(value = "Create a package type")
    @PostMapping("/Package-type")
    public PackageTypeDto create(
            @ApiParam(value = "PackageType", required = true)
            @Valid @RequestBody PackageTypeDto packageTypeDto) {
        PackageType inEntity = packageTypeDtoMapper.mapToEntity(packageTypeDto);
        PackageType savedEntity = packageTypeService.save(inEntity);
        return packageTypeDtoMapper.mapToDto(savedEntity);
    }

}