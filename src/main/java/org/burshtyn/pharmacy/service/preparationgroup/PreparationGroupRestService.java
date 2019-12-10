package org.burshtyn.pharmacy.service.preparationgroup;

import org.burshtyn.pharmacy.dto.PreparationGroupDto;
import org.burshtyn.pharmacy.entity.PreparationGroup;
import org.burshtyn.pharmacy.mapper.PreparationGroupDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PreparationGroupRestService {

    @Autowired
    private PreparationGroupDtoMapper dtoMapper;

    @Autowired
    private PreparationGroupService service;

    public PreparationGroupDto getOne(Long id) {
        Optional<PreparationGroup> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public PreparationGroupDto create(PreparationGroupDto dto) {
        PreparationGroup inEntity = dtoMapper.mapToEntity(dto);
        PreparationGroup savedEntity = service.save(inEntity);
        return dtoMapper.mapToDto(savedEntity);
    }

    public PreparationGroupDto update(Long id, PreparationGroupDto dto) {
        PreparationGroup entity = service.update(id, dto.getName());
        return dtoMapper.mapToDto(entity);
    }

    public List<PreparationGroupDto> getAll() {
        return service.findAll()
                .stream()
                .map(entity -> dtoMapper.mapToDto(entity)).collect(Collectors.toList());
    }
}
