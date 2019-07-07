package com.example.coinbackoffice.entity;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class AbstractDocument {

    @Id
    private String id;

    public AbstractDocument() {
    }

    public AbstractDocument(String id) {
        this.id = id;
    }

    public String getId() {
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
