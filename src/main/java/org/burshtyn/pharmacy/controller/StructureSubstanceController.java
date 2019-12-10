package org.burshtyn.pharmacy.controller;

import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.StructureSubstanceDto;
import org.burshtyn.pharmacy.service.structuresubstance.StructureSubstanceRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"Structure-substance"})
@SwaggerDefinition(tags = {
        @Tag(name = "Structure-substance", description = "Structure-substance REST API")
})
@RestController
public class StructureSubstanceController {

    @Autowired
    private StructureSubstanceRestService restService;

    @ApiOperation(value = "View a structure substance")
    @GetMapping("/structure-substances/{id}")
    public StructureSubstanceDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "View all structure substances")
    @GetMapping("/structure-substances")
    public List<StructureSubstanceDto> getAll() {
        return restService.getAll();
    }

    @ApiOperation(value = "Create a structure substance")
    @PostMapping("/structure-substances")
    public StructureSubstanceDto create(
            @ApiParam(value = "StructureSubstance", required = true)
            @Valid @RequestBody StructureSubstanceDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a structure substance")
    @PutMapping("/structure-substances/{id}")
    public StructureSubstanceDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "StructureSubstance", required = true)
            @Valid @RequestBody StructureSubstanceDto dto) {
        return restService.update(id, dto);
    }

}