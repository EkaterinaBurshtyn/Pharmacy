package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.PreparationGroupDto;
import org.burshtyn.pharmacy.service.preparationgroup.PreparationGroupRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"Preparation-group"})
@SwaggerDefinition(tags = {
        @Tag(name = "Preparation-group", description = "Preparation-group REST API")
})
@RestController
public class PreparationGroupController {

    @Autowired
    private PreparationGroupRestService restService;

    @ApiOperation(value = "View a preparation group")
    @GetMapping("/preparation-groups/{id}")
    public PreparationGroupDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "View all preparation groups")
    @GetMapping("/preparation-groups")
    public List<PreparationGroupDto> getAll() {
        return restService.getAll();
    }

    @ApiOperation(value = "Create a preparation group")
    @PostMapping("/preparation-groups")
    public PreparationGroupDto create(
            @ApiParam(value = "PreparationGroup", required = true)
            @Valid @RequestBody PreparationGroupDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a preparation group")
    @PutMapping("/preparation-groups/{id}")
    public PreparationGroupDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "PreparationGroup", required = true)
            @Valid @RequestBody PreparationGroupDto dto) {
        return restService.update(id, dto);
    }

}
