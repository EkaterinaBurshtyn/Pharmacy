package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.BaseDto;
import org.burshtyn.pharmacy.entity.BaseEntity;

public interface BaseDtoMapper<Dto extends BaseDto, Entity extends BaseEntity> {

    Dto mapToDto(Entity entity);

    Entity mapToEntity(Dto dto);

}