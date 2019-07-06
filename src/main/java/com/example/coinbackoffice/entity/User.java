package com.example.coinbackoffice.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User extends AbstractDocument{

    @DBRef
    private List<Wallet> wallets;

    public User() {
        this.wallets = new ArrayList<>();
    }

    public User(BigInteger id) {
        super(id);
        this.wallets = new ArrayList<>();
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void addWallet(Wallet newWallet){
        this.wallets.add(newWallet);
    }
}
