package com.zenika.ddd.domain.colis;

public class ColisId {

    private final String value;

    public ColisId(String value) {
        this.value = value;
    }

    public static ColisId generer() {
        return new ColisId("1234");
    }

}
