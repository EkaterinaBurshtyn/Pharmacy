package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.receipt.ReceiptDto;
import org.burshtyn.pharmacy.dto.sold.SoldDto;
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
        if (entity== null) {
            return null;
        }
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

    /**
     * Don't remove this method.
     * It has been created only for compatibility.
     */
    @Override
    public Receipt mapToEntity(ReceiptDto dto) {
        return null;
    }

}
