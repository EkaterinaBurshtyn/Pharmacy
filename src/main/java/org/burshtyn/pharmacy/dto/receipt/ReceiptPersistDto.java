package org.burshtyn.pharmacy.dto.receipt;

import org.burshtyn.pharmacy.dto.sold.SoldPersistDto;

import java.time.Instant;
import java.util.List;

public class ReceiptPersistDto {
    private List<SoldPersistDto> solds;
    private Instant date;

    public List<SoldPersistDto> getSolds() {
        return solds;
    }

    public void setSolds(List<SoldPersistDto> solds) {
        this.solds = solds;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
