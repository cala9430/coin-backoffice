package com.example.coinbackoffice.repository;

import com.example.coinbackoffice.entity.Transaction;
import com.example.coinbackoffice.entity.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findAllByFromIn(List<Wallet> wallets);

    List<Transaction> findAllByToIn(List<Wallet> wallets);

}
