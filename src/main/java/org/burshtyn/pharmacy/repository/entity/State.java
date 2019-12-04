package org.burshtyn.pharmacy.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State extends BaseEntity {

    @Column(name = "description")
    private String description;
}
