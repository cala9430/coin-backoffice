package com.example.coinbackoffice.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "transactions")
public class Transaction extends AbstractDocument{

    @DBRef
    private Wallet from;

    @DBRef
    private Wallet to;

    private BigDecimal amount;

    public Wallet getFrom() {
        return from;
    }

    public void setFrom(Wallet from) {
        this.from = from;
    }

    public Wallet getTo() {
        return to;
    }

    public void setTo(Wallet to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
