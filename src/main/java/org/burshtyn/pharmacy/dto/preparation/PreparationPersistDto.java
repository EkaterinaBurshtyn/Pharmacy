package org.burshtyn.pharmacy.dto.preparation;


import java.util.List;

public class PreparationPersistDto {
    private String name;
    private Long preparationGroupId;
    private List<Long> modeOfApplicationIds;
    private Long packageTypeId;
    private List<Long> indicationIds;
    private List<Long> contraindicationIds;
    private List<Long> structureSubstanceIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPreparationGroupId() {
        return preparationGroupId;
    }

    public void setPreparationGroupId(Long preparationGroupId) {
        this.preparationGroupId = preparationGroupId;
    }

    public List<Long> getModeOfApplicationIds() {
        return modeOfApplicationIds;
    }

    public void setModeOfApplicationIds(List<Long> modeOfApplicationIds) {
        this.modeOfApplicationIds = modeOfApplicationIds;
    }

    public Long getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Long packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    public List<Long> getIndicationIds() {
        return indicationIds;
    }

    public void setIndicationIds(List<Long> indicationIds) {
        this.indicationIds = indicationIds;
    }

    public List<Long> getContraindicationIds() {
        return contraindicationIds;
    }

    public void setContraindicationIds(List<Long> contraindicationIds) {
        this.contraindicationIds = contraindicationIds;
    }

    public List<Long> getStructureSubstanceIds() {
        return structureSubstanceIds;
    }

    public void setStructureSubstanceIds(List<Long> structureSubstanceIds) {
        this.structureSubstanceIds = structureSubstanceIds;
    }
}
