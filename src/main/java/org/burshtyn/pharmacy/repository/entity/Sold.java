package org.burshtyn.pharmacy.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sold")
public class Sold extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="id", insertable=false, updatable=false)
    private Preparation preparation;

    @Column(name = "price")
    private double price;

    @Column(name = "date")
    private Date date;
}
