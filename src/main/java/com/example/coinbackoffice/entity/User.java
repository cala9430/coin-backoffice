package com.example.coinbackoffice.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User extends AbstractDocument{

    @NotNull
    private String name;

    @NotNull
    private String email;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
