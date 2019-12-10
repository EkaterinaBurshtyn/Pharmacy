package org.burshtyn.pharmacy.dto.receipt;

import org.burshtyn.pharmacy.dto.BaseDto;
import org.burshtyn.pharmacy.dto.sold.SoldDto;

import java.time.Instant;
import java.util.List;

public class ReceiptDto extends BaseDto {
    private List<SoldDto> solds;
    private Instant date;

    public List<SoldDto> getSolds() {
        return solds;
    }

    public void setSolds(List<SoldDto> solds) {
        this.solds = solds;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
