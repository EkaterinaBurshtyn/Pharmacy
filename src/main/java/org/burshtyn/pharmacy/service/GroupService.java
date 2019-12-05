package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.Group;
import org.burshtyn.pharmacy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseServiceImpl<Group, GroupRepository> {

    @Autowired
    private GroupRepository repository;

    @Override
    protected GroupRepository getRepository() {
        return repository;
    }
}
