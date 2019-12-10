package org.burshtyn.pharmacy.service.structuresubstance;

import org.burshtyn.pharmacy.entity.StructureSubstance;
import org.burshtyn.pharmacy.repository.StructureSubstanceRepository;
import org.burshtyn.pharmacy.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StructureSubstanceService extends BaseServiceImpl<StructureSubstance, StructureSubstanceRepository> {

    @Autowired
    private StructureSubstanceRepository repository;

    @Override
    protected StructureSubstanceRepository getRepository() {
        return repository;
    }

    public StructureSubstance update(Long id, String name) {
        Optional<StructureSubstance> optional = findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        StructureSubstance entity = optional.get();

        entity.setName(name);

        return save(entity);
    }
}
