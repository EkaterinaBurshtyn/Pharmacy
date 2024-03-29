package org.burshtyn.pharmacy.entity;

import javax.persistence.*;

@Entity
@Table(name = "sold")
public class Sold extends BaseEntity {

    @OneToOne
    @JoinColumn(name="pr_id")
    private Preparation preparation;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "price_per_pack")
    private Double pricePerPack;

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerPack() {
        return pricePerPack;
    }

    public void setPricePerPack(Double pricePerPack) {
        this.pricePerPack = pricePerPack;
    }
}
