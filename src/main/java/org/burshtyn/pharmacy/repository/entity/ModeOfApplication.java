package org.burshtyn.pharmacy.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mode_of_application_preparation")
public class ModeOfApplication extends BaseEntity{

    @Column(name = "description")
    private String description;
}
