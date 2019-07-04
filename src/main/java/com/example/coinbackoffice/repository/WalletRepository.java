package com.example.coinbackoffice.repository;

import com.example.coinbackoffice.entity.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {
}
