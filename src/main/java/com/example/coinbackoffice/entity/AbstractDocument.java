package com.example.coinbackoffice.entity;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.Objects;

public class AbstractDocument {

    @Id
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDocument that = (AbstractDocument) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
