package com.example.coinbackoffice.api;

import com.example.coinbackoffice.entity.Wallet;

import java.util.List;

public class UserResponse {

    private String id;

    private String name;

    private String email;

    private List<Wallet> wallets;

    public UserResponse(String id, String name, String email, List<Wallet> wallets) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.wallets = wallets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }
}
