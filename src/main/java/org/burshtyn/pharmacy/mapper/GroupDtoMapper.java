package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.GroupDto;
import org.burshtyn.pharmacy.dto.GroupDto;
import org.burshtyn.pharmacy.entity.Group;
import org.burshtyn.pharmacy.entity.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupDtoMapper implements BaseDtoMapper<GroupDto, Group> {

    @Override
    public GroupDto mapToDto(Group entity) {
        GroupDto dto = new GroupDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public Group mapToEntity(GroupDto dto) {
        Group entity = new Group();
        entity.setName(dto.getName());
        return entity;
    }
}
