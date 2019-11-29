package org.burshtyn.pharmacy.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "preparation")
public class Preparation extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="id", insertable=false, updatable=false)
    private Group group;

    @Column(name="name")
    private String name;

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
}
