package org.burshtyn.pharmacy.service.receipt;

import org.burshtyn.pharmacy.dto.receipt.ReceiptDto;
import org.burshtyn.pharmacy.dto.receipt.ReceiptPersistDto;
import org.burshtyn.pharmacy.dto.sold.SoldPersistDto;
import org.burshtyn.pharmacy.entity.Receipt;
import org.burshtyn.pharmacy.entity.Sold;
import org.burshtyn.pharmacy.mapper.ReceiptDtoMapper;
import org.burshtyn.pharmacy.service.sold.SoldPersistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptRestService {

    @Autowired
    private ReceiptDtoMapper dtoMapper;
    @Autowired
    private ReceiptService service;
    @Autowired
    private SoldPersistService soldPersistService;

    public ReceiptDto getOne(Long id) {
        Optional<Receipt> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public void delete(Long id) {
        service.delete(id);
    }

    @Transactional
    public ReceiptDto create(ReceiptPersistDto dto) {
        List<Sold> soldList = getSolds(dto);
        return dtoMapper.mapToDto(service.create(dto.getDate(), soldList));
    }

    @Transactional
    public ReceiptDto update(Long id, ReceiptPersistDto dto) {
        Receipt entity = service.findOne(id).orElse(null);
        if (entity == null) {
            return null;
        }
        List<Sold> soldList = getSoldsForUpdate(entity, dto);
        return dtoMapper.mapToDto(service.update(id, dto.getDate(), soldList));
    }

    private List<Sold> getSolds(ReceiptPersistDto dto) {
        List<Sold> soldList = new ArrayList<>();
        for (SoldPersistDto soldPersistDto : dto.getSolds()) {
            Sold sold = soldPersistService.create(soldPersistDto);
            if (sold != null) {
                soldList.add(sold);
            }
        }
        return soldList;
    }

    private List<Sold> getSoldsForUpdate(Receipt receipt, ReceiptPersistDto dto) {
        List<Sold> soldList = new ArrayList<>();

        for (SoldPersistDto soldPersistDto : dto.getSolds()) {
            boolean newSoldFlag = true;
            for (Sold sold : receipt.getSolds()) {
                if (sold.getPreparation().getId().equals(soldPersistDto.getPreparationId())) {
                    newSoldFlag = false;
                    Sold newSold = soldPersistService.update(sold.getQuantity(), soldPersistDto);
                    if (newSold != null) {
                        soldList.add(newSold);
                    }
                    break;
                }
            }

            if (newSoldFlag) {
                Sold newSold = soldPersistService.create(soldPersistDto);
                if (newSold != null) {
                    soldList.add(newSold);
                }
            }

        }

        for (Sold sold : receipt.getSolds()) {
            boolean redundantSold = true;
            for (SoldPersistDto soldPersistDto : dto.getSolds()) {
                if (sold.getPreparation().getId().equals(soldPersistDto.getPreparationId())) {
                    redundantSold = false;
                    break;
                }
            }

            if (redundantSold) {
                soldPersistService.increaseAvailability(sold);
            }

        }

        return soldList;
    }

}
