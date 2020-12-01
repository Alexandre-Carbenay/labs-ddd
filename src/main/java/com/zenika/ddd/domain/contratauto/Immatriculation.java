package com.zenika.ddd.domain.contratauto;

import java.util.Objects;

public class Immatriculation {

    private final String value;

    public Immatriculation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Immatriculation that = (Immatriculation) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
