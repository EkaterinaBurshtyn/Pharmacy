package org.burshtyn.pharmacy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "preparation")
public class Preparation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "pr_gr_id", insertable = false, updatable = false)
    private PreparationGroup preparationGroup;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "mode_of_application_preparation",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ma_id", referencedColumnName = "id")
    )
    private List<ModeOfApplication> modesOfApplication = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pack_type_id", insertable = false, updatable = false)
    private PackageType packageType;

    @ManyToMany
    @JoinTable(
            name = "indication",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "st_id", referencedColumnName = "id")
    )
    private List<State> indications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "contraindication",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "st_id", referencedColumnName = "id")
    )
    private List<State> contraindications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "structure_substance_preparation",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ss_id", referencedColumnName = "id")
    )
    private List<StructureSubstance> structureSubstances = new ArrayList<>();

    public PreparationGroup getPreparationGroup() {
        return preparationGroup;
    }

    public void setPreparationGroup(PreparationGroup preparationGroup) {
        this.preparationGroup = preparationGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModeOfApplication> getModesOfApplication() {
        return modesOfApplication;
    }

    public void setModesOfApplication(List<ModeOfApplication> modesOfApplication) {
        this.modesOfApplication = modesOfApplication;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public List<State> getIndications() {
        return indications;
    }

    public void setIndications(List<State> indications) {
        this.indications = indications;
    }

    public List<State> getContraindications() {
        return contraindications;
    }

    public void setContraindications(List<State> contraindications) {
        this.contraindications = contraindications;
    }

    public List<StructureSubstance> getStructureSubstances() {
        return structureSubstances;
    }

    public void setStructureSubstances(List<StructureSubstance> structureSubstances) {
        this.structureSubstances = structureSubstances;
    }
}
