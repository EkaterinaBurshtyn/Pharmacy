package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.preparation.PreparationDto;
import org.burshtyn.pharmacy.dto.preparation.PreparationPersistDto;
import org.burshtyn.pharmacy.service.preparation.PreparationRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Preparation"})
@SwaggerDefinition(tags = {
        @Tag(name = "Preparation", description = "Preparation REST API")
})
@RestController
public class PreparationController {

    @Autowired
    private PreparationRestService restService;

    @ApiOperation(value = "View a preparation")
    @GetMapping("/preparations/{id}")
    public PreparationDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "Create a preparation")
    @PostMapping("/preparations")
    public PreparationDto create(
            @ApiParam(value = "Preparation", required = true)
            @Valid @RequestBody PreparationPersistDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a preparation")
    @PutMapping("/preparations/{id}")
    public PreparationDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "Preparation", required = true)
            @Valid @RequestBody PreparationPersistDto dto) {
        return restService.update(id, dto);
    }

    @ApiOperation(value = "Delete a preparation")
    @DeleteMapping("/preparations/{id}")
    public void delete(@PathVariable("id") Long id) {
        restService.delete(id);
    }

}
