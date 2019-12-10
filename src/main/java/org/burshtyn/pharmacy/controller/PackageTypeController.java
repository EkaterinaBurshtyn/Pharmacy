package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.PackageTypeDto;
import org.burshtyn.pharmacy.service.packagetype.PackageTypeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(tags = {"Package-type"})
@SwaggerDefinition(tags = {
        @Tag(name = "Package-type", description = "Package-type REST API")
})
@RestController
public class PackageTypeController {

    @Autowired
    private PackageTypeRestService restService;

    @ApiOperation(value = "View a package type")
    @GetMapping("/package-types/{id}")
    public PackageTypeDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "View all package types")
    @GetMapping("/package-types")
    public List<PackageTypeDto> getAll() {
        return restService.getAll();
    }

    @ApiOperation(value = "Create a package type")
    @PostMapping("/package-types")
    public PackageTypeDto create(
            @ApiParam(value = "PackageType", required = true)
            @Valid @RequestBody PackageTypeDto packageTypeDto) {
        return restService.create(packageTypeDto);
    }

    @ApiOperation(value = "Update a package type")
    @PutMapping("/package-types/{id}")
    public PackageTypeDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "PackageType", required = true)
            @Valid @RequestBody PackageTypeDto packageTypeDto) {
        return restService.update(id, packageTypeDto);
    }

}