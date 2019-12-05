package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.StructureSubstance;
import org.burshtyn.pharmacy.repository.StructureSubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StructureSubstanceService extends BaseServiceImpl<StructureSubstance, StructureSubstanceRepository> {

    @Autowired
    private StructureSubstanceRepository repository;

    @Override
    protected StructureSubstanceRepository getRepository() {
        return repository;
    }
}
