package org.burshtyn.pharmacy.dto.availability;


import org.burshtyn.pharmacy.dto.BaseDto;
import org.burshtyn.pharmacy.dto.preparation.PreparationDto;

public class AvailabilityDto extends BaseDto {

    private PreparationDto preparation;

    private Double quantity;

    public PreparationDto getPreparation() {
        return preparation;
    }

    public void setPreparation(PreparationDto preparation) {
        this.preparation = preparation;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
