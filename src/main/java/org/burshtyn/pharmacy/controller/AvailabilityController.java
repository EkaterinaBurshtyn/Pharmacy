package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.availability.AvailabilityDto;
import org.burshtyn.pharmacy.dto.availability.AvailabilityPersistDto;
import org.burshtyn.pharmacy.service.availability.AvailabilityRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Availability"})
@SwaggerDefinition(tags = {
        @Tag(name = "Availability", description = "Availability REST API")
})
@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityRestService restService;

    @ApiOperation(value = "View a availability")
    @GetMapping("/availability/{id}")
    public AvailabilityDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "Create a availability")
    @PostMapping("/availability")
    public AvailabilityDto create(
            @ApiParam(value = "Availability", required = true)
            @Valid @RequestBody AvailabilityPersistDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a availability")
    @PutMapping("/availability/{id}")
    public AvailabilityDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "Availability", required = true)
            @Valid @RequestBody AvailabilityPersistDto dto) {
        return restService.update(id, dto);
    }

}
