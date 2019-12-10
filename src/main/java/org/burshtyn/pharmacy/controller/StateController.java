package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.StateDto;
import org.burshtyn.pharmacy.entity.State;
import org.burshtyn.pharmacy.mapper.StateDtoMapper;
import org.burshtyn.pharmacy.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Api(tags = {"State"})
@SwaggerDefinition(tags = {
        @Tag(name = "State", description = "State REST API")
})
@RestController
public class StateController {

    @Autowired
    private StateDtoMapper stateDtoMapper;

    @Autowired
    private StateService stateService;

    @ApiOperation(value = "View a state")
    @GetMapping("/state/{id}")
    public StateDto get(
            @ApiParam(value = "State id", required = true)
            @PathVariable("id") Long id) {
        Optional<State> optionalState = stateService.findOne(id);
        if (optionalState.isPresent()) {
            return stateDtoMapper.mapToDto(optionalState.get());
        }
        return null;
    }


    @ApiOperation(value = "Create a state")
    @PostMapping("/state")
    public StateDto create(
            @ApiParam(value = "State", required = true)
            @Valid @RequestBody StateDto stateDto) {
        State inEntity = stateDtoMapper.mapToEntity(stateDto);
        State savedEntity = stateService.save(inEntity);
        return stateDtoMapper.mapToDto(savedEntity);
    }

}