package org.burshtyn.pharmacy.dto.sold;


public class SoldPersistDto {
    private Long preparationId;
    private Double quantity;
    private Double pricePerPack;

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

    public Double getPricePerPack() {
        return pricePerPack;
    }

    public void setPricePerPack(Double pricePerPack) {
        this.pricePerPack = pricePerPack;
    }
}
