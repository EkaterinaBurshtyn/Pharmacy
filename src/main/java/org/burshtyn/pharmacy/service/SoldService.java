package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.entity.Preparation;
import org.burshtyn.pharmacy.entity.Sold;
import org.burshtyn.pharmacy.repository.SoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldService extends BaseServiceImpl<Sold, SoldRepository> {

    @Autowired
    private SoldRepository repository;

    @Override
    protected SoldRepository getRepository() {
        return repository;
    }

    List<Sold> findByPreparation(Preparation preparation) {
        return repository.findByPreparation(preparation);
    }

}
