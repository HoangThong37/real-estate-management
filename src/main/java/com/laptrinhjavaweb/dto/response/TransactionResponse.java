package com.laptrinhjavaweb.dto.response;

public class TransactionResponse {

    private String createDate;
    private String note;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
