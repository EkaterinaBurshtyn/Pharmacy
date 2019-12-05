package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.Receipt;
import org.burshtyn.pharmacy.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptService extends BaseServiceImpl<Receipt, ReceiptRepository> {

    @Autowired
    private ReceiptRepository repository;

    @Override
    protected ReceiptRepository getRepository() {
        return repository;
    }
}
