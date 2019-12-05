package org.burshtyn.pharmacy.mapper;

import org.burshtyn.pharmacy.dto.*;
import org.burshtyn.pharmacy.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparationDtoMapper implements BaseDtoMapper<PreparationDto, Preparation> {

    @Autowired
    private PreparationGroupDtoMapper preparationGroupDtoMapper;

    @Autowired
    private ModeOfApplicationDtoMapper modeOfApplicationDtoMapper;

    @Autowired
    private PackageTypeDtoMapper packageTypeDtoMapper;

    @Autowired
    private StateDtoMapper stateDtoMapper;

    @Autowired
    private StructureSubstanceDtoMapper structureSubstanceDtoMapper;


    @Override
    public PreparationDto mapToDto(Preparation entity) {
        PreparationDto dto = new PreparationDto();
        dto.setId(entity.getId());
        dto.setGroup(preparationGroupDtoMapper.mapToDto(entity.getPreparationGroup()));
        dto.setName(entity.getName());

        if (entity.getModesOfApplication() != null && !entity.getModesOfApplication().isEmpty()) {
            List<ModeOfApplicationDto> modeOfApplicationList = new ArrayList<>();
            for (ModeOfApplication modeOfApplication : entity.getModesOfApplication()) {
                ModeOfApplicationDto modeOfApplicationDto = modeOfApplicationDtoMapper.mapToDto(modeOfApplication);
                modeOfApplicationList.add(modeOfApplicationDto);
            }
            dto.setModesOfApplication(modeOfApplicationList);
        }

        dto.setPackageType(packageTypeDtoMapper.mapToDto(entity.getPackageType()));

        if (entity.getIndications() != null && !entity.getIndications().isEmpty()) {
            List<StateDto> stateDtoList = new ArrayList<>();
            for (State state : entity.getIndications()) {
                StateDto stateDto = stateDtoMapper.mapToDto(state);
                stateDtoList.add(stateDto);
            }
            dto.setIndications(stateDtoList);
        }

        if (entity.getContraindications() != null && !entity.getContraindications().isEmpty()) {
            List<StateDto> stateDtoList = new ArrayList<>();
            for (State state : entity.getContraindications()) {
                StateDto stateDto = stateDtoMapper.mapToDto(state);
                stateDtoList.add(stateDto);
            }
            dto.setContraindications(stateDtoList);
        }

        if (entity.getStructureSubstances() != null && !entity.getStructureSubstances().isEmpty()) {
            List<StructureSubstanceDto> structureSubstanceDtoList = new ArrayList<>();
            for (StructureSubstance structureSubstance : entity.getStructureSubstances()) {
                StructureSubstanceDto structureSubstanceDto = structureSubstanceDtoMapper.mapToDto(structureSubstance);
                structureSubstanceDtoList.add(structureSubstanceDto);
            }
            dto.setStructureSubstances(structureSubstanceDtoList);
        }

        return dto;
    }

    @Override
    public Preparation mapToEntity(PreparationDto dto) {
        Preparation entity = new Preparation();
        entity.setName(dto.getName());
        return entity;
    }

}
