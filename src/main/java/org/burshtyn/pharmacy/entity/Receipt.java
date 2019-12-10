package org.burshtyn.pharmacy.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receipt")
public class Receipt extends BaseEntity {

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
    private List<Sold> solds = new ArrayList<>();

    @Column(name = "date_time")
    private Instant date;

    public List<Sold> getSolds() {
        return solds;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void addSold (Sold sold) {
        sold.setReceipt(this);
        solds.add(sold);
    }

}
