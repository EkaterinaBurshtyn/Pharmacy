package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.Availability;
import org.burshtyn.pharmacy.entity.Preparation;
import org.burshtyn.pharmacy.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService extends BaseServiceImpl<Availability, AvailabilityRepository> {

    @Autowired
    private AvailabilityRepository repository;

    @Override
    protected AvailabilityRepository getRepository() {
        return repository;
    }

    List<Availability> findByPreparation(Preparation preparation) {
        return repository.findByPreparation(preparation);
    }
}
