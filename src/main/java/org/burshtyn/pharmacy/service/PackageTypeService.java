package org.burshtyn.pharmacy.service;

import org.burshtyn.pharmacy.entity.PackageType;
import org.burshtyn.pharmacy.repository.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageTypeService extends BaseServiceImpl<PackageType, PackageTypeRepository> {

    @Autowired
    private PackageTypeRepository repository;

    @Override
    protected PackageTypeRepository getRepository() {
        return repository;
    }
}
