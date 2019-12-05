package org.burshtyn.pharmacy.entity;

import javax.persistence.*;

@Entity
@Table(name = "availability")
public class Availability extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "pr_id", insertable = false, updatable = false)
    private Preparation preparation;

    @Column(name = "quantity")
    private Double quantity;

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
