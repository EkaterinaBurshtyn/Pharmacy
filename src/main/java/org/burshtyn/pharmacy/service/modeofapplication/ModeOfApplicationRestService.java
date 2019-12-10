package org.burshtyn.pharmacy.service.modeofapplication;

import org.burshtyn.pharmacy.dto.ModeOfApplicationDto;
import org.burshtyn.pharmacy.entity.ModeOfApplication;
import org.burshtyn.pharmacy.mapper.ModeOfApplicationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeOfApplicationRestService {

    @Autowired
    private ModeOfApplicationDtoMapper dtoMapper;

    @Autowired
    private ModeOfApplicationService service;

    public ModeOfApplicationDto getOne(Long id) {
        Optional<ModeOfApplication> optional = service.findOne(id);
        if (!optional.isPresent()) {
            return null;
        }
        return dtoMapper.mapToDto(optional.get());
    }

    public ModeOfApplicationDto create(ModeOfApplicationDto dto) {
        ModeOfApplication inEntity = dtoMapper.mapToEntity(dto);
        ModeOfApplication savedEntity = service.save(inEntity);
        return dtoMapper.mapToDto(savedEntity);
    }

    public ModeOfApplicationDto update(Long id, ModeOfApplicationDto dto) {
        ModeOfApplication entity = service.update(id, dto.getDescription());
        return dtoMapper.mapToDto(entity);
    }

    public List<ModeOfApplicationDto> getAll() {
        return service.findAll()
                .stream()
                .map(entity -> dtoMapper.mapToDto(entity)).collect(Collectors.toList());
    }

}
