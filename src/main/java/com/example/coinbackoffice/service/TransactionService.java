package com.example.coinbackoffice.service;

import com.example.coinbackoffice.api.TransactionResponse;
import com.example.coinbackoffice.entity.Transaction;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<TransactionResponse> findTransactionsForWallets(List<Wallet> wallets){

        List<Transaction> received = this.transactionRepository.findAllByFromIn(wallets);

        Set<TransactionResponse> result = new HashSet<>(this.mapTransactionToResponse(received, true));

        List<Transaction> sent = this.transactionRepository.findAllByToIn(wallets);

        result.addAll(this.mapTransactionToResponse(sent, false));

        return result;
    }

    private Set<TransactionResponse> mapTransactionToResponse(List<Transaction> transactions, boolean received){
        Set<TransactionResponse> result = new HashSet<>();
        for (Transaction transaction : transactions) {
            result.add(new TransactionResponse(transaction.getId(),
                    transaction.getFrom().getId(), transaction.getTo().getId(), transaction.getAmount(), received));
        }
        return result;
    }

}
