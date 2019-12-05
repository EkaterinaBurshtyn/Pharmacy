package org.burshtyn.pharmacy.dto;


public class SoldDto extends BaseDto {

    private PreparationDto preparation;

    private ReceiptDto receipt;

    private Double quantity;

    private Double pricePerPack;

    public PreparationDto getPreparation() {
        return preparation;
    }

    public void setPreparation(PreparationDto preparation) {
        this.preparation = preparation;
    }

    public ReceiptDto getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDto receipt) {
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
