package org.burshtyn.pharmacy.entity.sale;

import org.burshtyn.pharmacy.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receipt")
public class Receipt extends BaseEntity {

    @OneToMany(mappedBy = "receipt")
    private List<Sold> solds = new ArrayList<>();

    @Column(name = "date_time")
    private Instant date;

    public List<Sold> getSolds() {
        return solds;
    }

    public void setSolds(List<Sold> solds) {
        this.solds = solds;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
