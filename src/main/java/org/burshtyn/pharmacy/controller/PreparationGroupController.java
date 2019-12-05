package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.PreparationGroupDto;
import org.burshtyn.pharmacy.entity.PreparationGroup;
import org.burshtyn.pharmacy.mapper.PreparationGroupDtoMapper;
import org.burshtyn.pharmacy.service.PreparationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Api(tags = {"Preparation-group"})
@SwaggerDefinition(tags = {
        @Tag(name = "Preparation-group", description = "Preparation-group REST API")
})
@RestController
public class PreparationGroupController {

    @Autowired
    private PreparationGroupDtoMapper preparationGroupDtoMapper;

    @Autowired
    private PreparationGroupService preparationGroupService;

    @ApiOperation(value = "View a preparation group")
    @GetMapping("/preparation-groups/{id}")
    public PreparationGroupDto get(
            @ApiParam(value = "Preparation group id", required = true)
            @PathVariable("id") Long id) {
        Optional<PreparationGroup> optionalPreparationGroup = preparationGroupService.findOne(id);
        if (optionalPreparationGroup.isPresent()) {
            return preparationGroupDtoMapper.mapToDto(optionalPreparationGroup.get());
        }
        return null;
    }


    @ApiOperation(value = "Create a preparation group")
    @PostMapping("/preparation-groups")
    public PreparationGroupDto create(
            @ApiParam(value = "PreparationGroup", required = true)
            @Valid @RequestBody PreparationGroupDto preparationGroupDto) {
        PreparationGroup inEntity = preparationGroupDtoMapper.mapToEntity(preparationGroupDto);
        PreparationGroup savedEntity = preparationGroupService.save(inEntity);
        return preparationGroupDtoMapper.mapToDto(savedEntity);
    }

}
