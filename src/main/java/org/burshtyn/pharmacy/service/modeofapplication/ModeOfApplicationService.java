package org.burshtyn.pharmacy.service.modeofapplication;

import org.burshtyn.pharmacy.entity.ModeOfApplication;
import org.burshtyn.pharmacy.repository.ModeOfApplicationRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeOfApplicationService extends BaseServiceImpl<ModeOfApplication, ModeOfApplicationRepository> {

    @Autowired
    private ModeOfApplicationRepository repository;

    @Override
    protected ModeOfApplicationRepository getRepository() {
        return repository;
    }

    public ModeOfApplication update(Long id, String description) {
        Optional<ModeOfApplication> optional = findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        ModeOfApplication entity = optional.get();

        entity.setDescription(description);

        return save(entity);
    }
}
