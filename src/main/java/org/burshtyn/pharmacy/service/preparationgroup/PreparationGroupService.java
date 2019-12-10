package org.burshtyn.pharmacy.service.preparationgroup;

import org.burshtyn.pharmacy.entity.PreparationGroup;
import org.burshtyn.pharmacy.repository.PreparationGroupRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreparationGroupService extends BaseServiceImpl<PreparationGroup, PreparationGroupRepository> {

    @Autowired
    private PreparationGroupRepository repository;

    @Override
    protected PreparationGroupRepository getRepository() {
        return repository;
    }

    public PreparationGroup update(Long id, String name) {
        Optional<PreparationGroup> optional = findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        PreparationGroup entity = optional.get();

        entity.setName(name);

        return save(entity);
    }
}
