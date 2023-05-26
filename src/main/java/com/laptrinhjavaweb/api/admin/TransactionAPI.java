//package com.laptrinhjavaweb.api.admin;
//
//import com.laptrinhjavaweb.dto.TransactionDTO;
//import com.laptrinhjavaweb.service.ITransactionService;
//import javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/transaction")
//public class TransactionAPI {
//
//    @Autowired
//    private ITransactionService transactionService;
//
//    @PostMapping
//    private ResponseEntity<Void> saveTransaction(@RequestBody TransactionDTO transaction) throws NotFoundException {
//        transactionService.save(transaction);
//        return ResponseEntity.noContent().build();
//    }
//}
