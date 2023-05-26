package com.laptrinhjavaweb.enums;

public enum TransactionsEnum {

    QUA_TRINH_CSKH("QÚA TRÌNH CSKH"),
    DAN_DI_XEM("Dẫn khách đi xem"),
    DUA_KHACH_DI_QUAY("Đưa khách đi quẩy");

    private final String transactionTypeValue;

    public String getTransactionTypeValue() {
        return transactionTypeValue;
    }

    TransactionsEnum(String transactionTypeValue) {
        this.transactionTypeValue = transactionTypeValue;
    }

}
