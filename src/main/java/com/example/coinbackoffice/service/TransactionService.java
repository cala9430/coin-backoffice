package com.example.coinbackoffice.service;

import com.example.coinbackoffice.entity.Transaction;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Wallet from, Wallet to, BigDecimal amount){
        Transaction transaction= new Transaction();
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setAmount(amount);
        return this.transactionRepository.save(transaction);
    }

    public List<Transaction> findTransactionsForWallets(List<Wallet> wallets){
        return this.transactionRepository.findAllByFromIn(wallets);
    }

}
