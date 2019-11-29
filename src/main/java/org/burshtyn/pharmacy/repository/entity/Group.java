package org.burshtyn.pharmacy.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group")
public class Group extends BaseEntity {

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Preparation> preparations = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
