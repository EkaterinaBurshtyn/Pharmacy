package org.burshtyn.pharmacy.controller;

import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.ModeOfApplicationDto;
import org.burshtyn.pharmacy.dto.PackageTypeDto;
import org.burshtyn.pharmacy.mapper.ModeOfApplicationDtoMapper;
import org.burshtyn.pharmacy.service.modeofapplication.ModeOfApplicationRestService;
import org.burshtyn.pharmacy.service.modeofapplication.ModeOfApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(tags = {"Mode-Of-Application"})
@SwaggerDefinition(tags = {
        @Tag(name = "Mode Of Application", description = "Mode-Of-Application REST API")
})
@RestController
public class ModeOfApplicationController {

    @Autowired
    private ModeOfApplicationRestService restService;

    @ApiOperation(value = "View a Mode Of Application")
    @GetMapping("/modes-of-application/{id}")
    public ModeOfApplicationDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "View all modes of application")
    @GetMapping("/modes-of-application")
    public List<ModeOfApplicationDto> getAll() {
        return restService.getAll();
    }

    @ApiOperation(value = "Create a Mode Of Application")
    @PostMapping("/modes-of-application")
    public ModeOfApplicationDto create(
            @ApiParam(value = "ModeOfApplication", required = true)
            @Valid @RequestBody ModeOfApplicationDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a Mode Of Application")
    @PutMapping("/modes-of-application/{id}")
    public ModeOfApplicationDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "ModeOfApplication", required = true)
            @Valid @RequestBody ModeOfApplicationDto dto) {
        return restService.update(id, dto);
    }

}