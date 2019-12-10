package org.burshtyn.pharmacy.controller;


import io.swagger.annotations.*;
import org.burshtyn.pharmacy.dto.receipt.ReceiptDto;
import org.burshtyn.pharmacy.dto.receipt.ReceiptPersistDto;
import org.burshtyn.pharmacy.service.receipt.ReceiptRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Receipt"})
@SwaggerDefinition(tags = {
        @Tag(name = "Receipt", description = "Receipt REST API")
})
@RestController
public class ReceiptController {

    @Autowired
    private ReceiptRestService restService;

    @ApiOperation(value = "View a receipt")
    @GetMapping("/receipts/{id}")
    public ReceiptDto get(@PathVariable("id") Long id) {
        return restService.getOne(id);
    }

    @ApiOperation(value = "Create a receipt")
    @PostMapping("/receipts")
    public ReceiptDto create(
            @ApiParam(value = "Receipt", required = true)
            @Valid @RequestBody ReceiptPersistDto dto) {
        return restService.create(dto);
    }

    @ApiOperation(value = "Update a receipt")
    @PutMapping("/receipts/{id}")
    public ReceiptDto update(
            @PathVariable("id") Long id,
            @ApiParam(value = "Receipt", required = true)
            @Valid @RequestBody ReceiptPersistDto dto) {
        return restService.update(id, dto);
    }

    @ApiOperation(value = "Delete a receipt")
    @DeleteMapping("/receipts/{id}")
    public void delete(@PathVariable("id") Long id) {
        restService.delete(id);
    }

}
