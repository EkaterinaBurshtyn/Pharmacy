package org.burshtyn.pharmacy.entity;

import org.burshtyn.pharmacy.entity.indication.Contraindication;
import org.burshtyn.pharmacy.entity.indication.Indication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<ModeOfApplication> modesOfApplication = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pack_type_id", insertable = false, updatable = false)
    private PackageType packageType;

    @OneToMany(mappedBy = "preparation")
    private List<Indication> indications = new ArrayList<>();

    @OneToMany(mappedBy = "preparation")
    private List<Contraindication> contraindications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "structure_substance_preparation",
            joinColumns = @JoinColumn(name = "pr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ss_id", referencedColumnName = "id")
    )
    private List<StructureSubstance> structureSubstances = new ArrayList<>();

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

    public List<Indication> getIndications() {
        return indications;
    }

    public void setIndications(List<Indication> indications) {
        this.indications = indications;
    }

    public List<Contraindication> getContraindications() {
        return contraindications;
    }

    public void setContraindications(List<Contraindication> contraindications) {
        this.contraindications = contraindications;
    }

    public List<StructureSubstance> getStructureSubstances() {
        return structureSubstances;
    }

    public void setStructureSubstances(List<StructureSubstance> structureSubstances) {
        this.structureSubstances = structureSubstances;
    }

}
