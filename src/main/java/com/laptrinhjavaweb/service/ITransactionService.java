package com.laptrinhjavaweb.service;
import com.laptrinhjavaweb.dto.request.TransactionRequest;
import javassist.NotFoundException;

public interface ITransactionService {

    void save(TransactionRequest transaction) throws NotFoundException;
}
