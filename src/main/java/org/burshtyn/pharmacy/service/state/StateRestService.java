package org.burshtyn.pharmacy.service.state;

import org.burshtyn.pharmacy.dto.StateDto;
import org.burshtyn.pharmacy.entity.State;
import org.burshtyn.pharmacy.mapper.StateDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateRestService {

    @Autowired
    private StateDtoMapper dtoMapper;

    @Autowired
    private StateService service;

    public StateDto getOne(Long id) {
        Optional<State> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public StateDto create(StateDto dto) {
        State inEntity = dtoMapper.mapToEntity(dto);
        State savedEntity = service.save(inEntity);
        return dtoMapper.mapToDto(savedEntity);
    }

    public StateDto update(Long id, StateDto dto) {
        State entity = service.update(id, dto.getDescription());
        return dtoMapper.mapToDto(entity);
    }

    public List<StateDto> getAll() {
        return service.findAll()
                .stream()
                .map(entity -> dtoMapper.mapToDto(entity)).collect(Collectors.toList());
    }

}
