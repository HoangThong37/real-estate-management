package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.request.TransactionRequest;
import com.laptrinhjavaweb.service.ITransactionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionAPI {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    private ResponseEntity<Void> saveTransaction(@RequestBody TransactionRequest transactionRequest) throws NotFoundException {
        transactionService.save(transactionRequest);
        return ResponseEntity.noContent().build();
    }
}
