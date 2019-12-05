package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.PreparationGroup;
import org.burshtyn.pharmacy.repository.PreparationGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PreparationGroupService extends BaseServiceImpl<PreparationGroup, PreparationGroupRepository> {

    @Autowired
    private PreparationGroupRepository repository;

    @Override
    protected PreparationGroupRepository getRepository() {
        return repository;
    }
}
