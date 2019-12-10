package org.burshtyn.pharmacy.dto.availability;


public class AvailabilityPersistDto {
    private Long preparationId;
    private Double quantity;

    public Long getPreparationId() {
        return preparationId;
    }

    public void setPreparationId(Long preparationId) {
        this.preparationId = preparationId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
