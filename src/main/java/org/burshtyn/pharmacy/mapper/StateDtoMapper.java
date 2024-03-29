package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.StateDto;
import org.burshtyn.pharmacy.entity.State;
import org.springframework.stereotype.Service;

@Service
public class StateDtoMapper implements BaseDtoMapper<StateDto, State> {

    @Override
    public StateDto mapToDto(State entity) {
        if (entity== null) {
            return null;
        }
        StateDto dto = new StateDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public State mapToEntity(StateDto dto) {
        if (dto== null) {
            return null;
        }
        State entity = new State();
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
