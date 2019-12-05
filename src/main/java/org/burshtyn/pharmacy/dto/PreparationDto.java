package org.burshtyn.pharmacy.dto;


import java.util.List;

public class PreparationDto extends BaseDto {

    private PreparationGroupDto group;

    private String name;

    private List<ModeOfApplicationDto> modesOfApplication;

    private PackageTypeDto packageType;

    private List<StateDto> indications;

    private List<StateDto> contraindications;

    private List<StructureSubstanceDto> structureSubstances;

    public PreparationGroupDto getGroup() {
        return group;
    }

    public void setGroup(PreparationGroupDto group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModeOfApplicationDto> getModesOfApplication() {
        return modesOfApplication;
    }

    public void setModesOfApplication(List<ModeOfApplicationDto> modesOfApplication) {
        this.modesOfApplication = modesOfApplication;
    }

    public PackageTypeDto getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageTypeDto packageType) {
        this.packageType = packageType;
    }

    public List<StateDto> getIndications() {
        return indications;
    }

    public void setIndications(List<StateDto> indications) {
        this.indications = indications;
    }

    public List<StateDto> getContraindications() {
        return contraindications;
    }

    public void setContraindications(List<StateDto> contraindications) {
        this.contraindications = contraindications;
    }

    public List<StructureSubstanceDto> getStructureSubstances() {
        return structureSubstances;
    }

    public void setStructureSubstances(List<StructureSubstanceDto> structureSubstances) {
        this.structureSubstances = structureSubstances;
    }
}
