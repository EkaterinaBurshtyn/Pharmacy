package org.burshtyn.pharmacy.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "preparation")
public class Preparation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "gr_id", insertable = false, updatable = false)
    private Group group;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "mode_of_application_preparation",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ma_id", referencedColumnName = "id")
    )
    private Set<ModeOfApplication> modesOfApplication = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "pack_type_id", insertable = false, updatable = false)
    private PackageType packageType;

    @ManyToMany
    @JoinTable(
            name = "indication",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "st_id", referencedColumnName = "id")
    )
    private Set<State> indications = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "contraindication",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "st_id", referencedColumnName = "id")
    )
    private Set<State> contraindications = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "structure_substance_preparation",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ss_id", referencedColumnName = "id")
    )
    private Set<StructureSubstance> structureSubstances = new HashSet<>();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ModeOfApplication> getModesOfApplication() {
        return modesOfApplication;
    }

    public void setModesOfApplication(Set<ModeOfApplication> modesOfApplication) {
        this.modesOfApplication = modesOfApplication;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public Set<State> getIndications() {
        return indications;
    }

    public void setIndications(Set<State> indications) {
        this.indications = indications;
    }

    public Set<State> getContraindications() {
        return contraindications;
    }

    public void setContraindications(Set<State> contraindications) {
        this.contraindications = contraindications;
    }

    public Set<StructureSubstance> getStructureSubstances() {
        return structureSubstances;
    }

    public void setStructureSubstances(Set<StructureSubstance> structureSubstances) {
        this.structureSubstances = structureSubstances;
    }
}
