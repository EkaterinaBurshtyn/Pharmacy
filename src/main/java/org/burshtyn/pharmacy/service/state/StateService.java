package org.burshtyn.pharmacy.service.state;

import org.burshtyn.pharmacy.entity.State;
import org.burshtyn.pharmacy.repository.StateRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService extends BaseServiceImpl<State, StateRepository> {

    @Autowired
    private StateRepository repository;

    @Override
    protected StateRepository getRepository() {
        return repository;
    }

    public State update(Long id, String description) {
        Optional<State> optional = findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        State entity = optional.get();

        entity.setDescription(description);

        return save(entity);
    }
}
