package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.StateDto;
import org.burshtyn.pharmacy.service.state.StateRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"State"})
@SwaggerDefinition(tags = {
        @Tag(name = "State", description = "State REST API")
})
@RestController
public class StateController {

    @Autowired
    private StateRestService restService;

    @ApiOperation(value = "View a state")
    @GetMapping("/states/{id}")
    public StateDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "View all states")
    @GetMapping("/states")
    public List<StateDto> getAll() {
        return restService.getAll();
    }

    @ApiOperation(value = "Create a state")
    @PostMapping("/states")
    public StateDto create(
            @ApiParam(value = "State", required = true)
            @Valid @RequestBody StateDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a state")
    @PutMapping("/states/{id}")
    public StateDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "State", required = true)
            @Valid @RequestBody StateDto dto) {
        return restService.update(id, dto);
    }

}