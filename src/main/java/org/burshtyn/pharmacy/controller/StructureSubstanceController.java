package org.burshtyn.pharmacy.controller;

import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.StructureSubstanceDto;
import org.burshtyn.pharmacy.entity.StructureSubstance;
import org.burshtyn.pharmacy.mapper.StructureSubstanceDtoMapper;
import org.burshtyn.pharmacy.service.StructureSubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Api(tags = {"Structure-substance"})
@SwaggerDefinition(tags = {
        @Tag(name = "Structure-substance", description = "Structure-substance REST API")
})
@RestController
public class StructureSubstanceController {

    @Autowired
    private StructureSubstanceDtoMapper structureSubstanceDtoMapper;

    @Autowired
    private StructureSubstanceService structureSubstanceService;

    @ApiOperation(value = "View a structure substance")
    @GetMapping("/structure substance/{id}")
    public StructureSubstanceDto get(
            @ApiParam(value = "Structure substance id", required = true)
            @PathVariable("id") Long id) {
        Optional<StructureSubstance> optionalStructureSubstance = structureSubstanceService.findOne(id);
        if (optionalStructureSubstance.isPresent()) {
            return structureSubstanceDtoMapper.mapToDto(optionalStructureSubstance.get());
        }
        return null;
    }


    @ApiOperation(value = "Create a structure substance")
    @PostMapping("/Structure-substance")
    public StructureSubstanceDto create(
            @ApiParam(value = "StructureSubstance", required = true)
            @Valid @RequestBody StructureSubstanceDto structureSubstanceDto) {
        StructureSubstance inEntity = structureSubstanceDtoMapper.mapToEntity(structureSubstanceDto);
        StructureSubstance savedEntity = structureSubstanceService.save(inEntity);
        return structureSubstanceDtoMapper.mapToDto(savedEntity);
    }

}