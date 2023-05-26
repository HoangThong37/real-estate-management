package com.laptrinhjavaweb.service;
import com.laptrinhjavaweb.dto.TransactionDTO;
import javassist.NotFoundException;

import java.util.List;


public interface ITransactionService {

    TransactionDTO save(TransactionDTO transaction) throws NotFoundException;
    List<TransactionDTO> findTransactionByCustomer(Long customerId);
    List<TransactionDTO> findAllTransaction();

}
