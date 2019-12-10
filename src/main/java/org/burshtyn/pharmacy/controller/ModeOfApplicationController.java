package org.burshtyn.pharmacy.controller;

import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.ModeOfApplicationDto;
import org.burshtyn.pharmacy.entity.ModeOfApplication;
import org.burshtyn.pharmacy.mapper.ModeOfApplicationDtoMapper;
import org.burshtyn.pharmacy.service.ModeOfApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Api(tags = {"Mode-Of-Application"})
@SwaggerDefinition(tags = {
        @Tag(name = "Mode Of Application", description = "Mode-Of-Application REST API")
})
@RestController
public class ModeOfApplicationController {

    @Autowired
    private ModeOfApplicationDtoMapper modeOfApplicationDtoMapper;

    @Autowired
    private ModeOfApplicationService modeOfApplicationService;

    @ApiOperation(value = "View a Mode Of Application")
    @GetMapping("/Mode Of Application/{id}")
    public ModeOfApplicationDto get(
            @ApiParam(value = "Mode Of Application id", required = true)
            @PathVariable("id") Long id) {
        Optional<ModeOfApplication> optionalModeOfApplication = modeOfApplicationService.findOne(id);
        if (optionalModeOfApplication.isPresent()) {
            return modeOfApplicationDtoMapper.mapToDto(optionalModeOfApplication.get());
        }
        return null;
    }


    @ApiOperation(value = "Create a Mode Of Application")
    @PostMapping("/Mode-Of-Application")
    public ModeOfApplicationDto create(
            @ApiParam(value = "ModeOfApplication", required = true)
            @Valid @RequestBody ModeOfApplicationDto modeOfApplicationDto) {
        ModeOfApplication inEntity = modeOfApplicationDtoMapper.mapToEntity(modeOfApplicationDto);
        ModeOfApplication savedEntity = modeOfApplicationService.save(inEntity);
        return modeOfApplicationDtoMapper.mapToDto(savedEntity);
    }

}