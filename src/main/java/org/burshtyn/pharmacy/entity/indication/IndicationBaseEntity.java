package org.burshtyn.pharmacy.entity.indication;

import org.burshtyn.pharmacy.entity.BaseEntity;
import org.burshtyn.pharmacy.entity.Preparation;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IndicationBaseEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "pr_id", insertable = false, updatable = false)
    private Preparation preparation;

    @ManyToOne
    @JoinColumn(name = "st_id", insertable = false, updatable = false)
    private State state;

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
