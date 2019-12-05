package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.State;
import org.burshtyn.pharmacy.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService extends BaseServiceImpl<State, StateRepository> {

    @Autowired
    private StateRepository repository;

    @Override
    protected StateRepository getRepository() {
        return repository;
    }
}
