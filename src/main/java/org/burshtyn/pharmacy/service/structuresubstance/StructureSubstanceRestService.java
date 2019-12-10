package org.burshtyn.pharmacy.service.structuresubstance;

import org.burshtyn.pharmacy.dto.StructureSubstanceDto;
import org.burshtyn.pharmacy.entity.StructureSubstance;
import org.burshtyn.pharmacy.mapper.StructureSubstanceDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StructureSubstanceRestService {

    @Autowired
    private StructureSubstanceDtoMapper dtoMapper;

    @Autowired
    private StructureSubstanceService service;

    public StructureSubstanceDto getOne(Long id) {
        Optional<StructureSubstance> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public StructureSubstanceDto create(StructureSubstanceDto dto) {
        StructureSubstance inEntity = dtoMapper.mapToEntity(dto);
        StructureSubstance savedEntity = service.save(inEntity);
        return dtoMapper.mapToDto(savedEntity);
    }

    public StructureSubstanceDto update(Long id, StructureSubstanceDto dto) {
        StructureSubstance entity = service.update(id, dto.getName());
        return dtoMapper.mapToDto(entity);
    }

    public List<StructureSubstanceDto> getAll() {
        return service.findAll()
                .stream()
                .map(entity -> dtoMapper.mapToDto(entity)).collect(Collectors.toList());
    }

}
