package com.laptrinhjavaweb.dto.request;

public class TransactionRequest {

    private String note;
    private Long customerId;  // khách hàng

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
