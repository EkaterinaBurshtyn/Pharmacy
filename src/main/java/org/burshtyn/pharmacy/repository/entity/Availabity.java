package org.burshtyn.pharmacy.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "availabity")
public class Availabity extends BaseEntity {

    @OneToOne
    @JoinColumn(name="id", insertable=false, updatable=false)
    private Preparation preparation;

    @Column(name="quantity")
    private String quantity;

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
