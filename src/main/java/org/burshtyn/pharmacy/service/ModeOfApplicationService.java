package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.ModeOfApplication;
import org.burshtyn.pharmacy.repository.ModeOfApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeOfApplicationService extends BaseServiceImpl<ModeOfApplication, ModeOfApplicationRepository> {

    @Autowired
    private ModeOfApplicationRepository repository;

    @Override
    protected ModeOfApplicationRepository getRepository() {
        return repository;
    }
}
