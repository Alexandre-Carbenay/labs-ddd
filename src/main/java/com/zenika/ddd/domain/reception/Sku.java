package com.zenika.ddd.domain.reception;

public class Sku {
    private final String value;

    public Sku(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
