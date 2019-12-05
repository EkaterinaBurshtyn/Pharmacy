package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.ReceiptDto;
import org.burshtyn.pharmacy.dto.SoldDto;
import org.burshtyn.pharmacy.entity.Receipt;
import org.burshtyn.pharmacy.entity.Sold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptDtoMapper implements BaseDtoMapper<ReceiptDto, Receipt> {

    @Autowired
    private SoldDtoMapper soldDtoMapper;

    @Override
    public ReceiptDto mapToDto(Receipt entity) {
        ReceiptDto dto = new ReceiptDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());

        if (entity.getSolds() != null && !entity.getSolds().isEmpty()) {
            List<SoldDto> soldDtoList = new ArrayList<>();
            for (Sold sold : entity.getSolds()) {
                SoldDto soldDto = soldDtoMapper.mapToDto(sold);
                soldDtoList.add(soldDto);
            }
            dto.setSolds(soldDtoList);
        }

        return dto;
    }

    @Override
    public Receipt mapToEntity(ReceiptDto dto) {
        Receipt entity = new Receipt();
        entity.setDate(dto.getDate());
        return entity;
    }

}
