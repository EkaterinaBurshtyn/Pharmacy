package org.burshtyn.pharmacy.service.receipt;

import org.burshtyn.pharmacy.dto.receipt.ReceiptPersistDto;
import org.burshtyn.pharmacy.entity.Receipt;
import org.burshtyn.pharmacy.entity.Sold;
import org.burshtyn.pharmacy.repository.ReceiptRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService extends BaseServiceImpl<Receipt, ReceiptRepository> {

    @Autowired
    private ReceiptRepository repository;

    @Override
    protected ReceiptRepository getRepository() {
        return repository;
    }

    public Receipt create(Instant date, List<Sold> soldList) {
        Receipt entity = new Receipt();
        fillEntity(entity, date, soldList);
        return save(entity);
    }

    private void fillEntity(Receipt entity, Instant date, List<Sold> soldList) {
        entity.setDate(date);
        for (Sold sold : soldList) {
            entity.addSold(sold);
        }
    }

    @Transactional
    public Receipt update(Long id, Instant date, List<Sold> soldList) {
        Optional<Receipt> optional = findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        Receipt entity = optional.get();

        fillEntity(entity, date, soldList);

        return save(entity);
    }

}
