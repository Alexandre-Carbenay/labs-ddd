package com.zenika.ddd.domain.contratauto;

import java.util.Objects;

public class ContratAutoId {
    private final String value;

    public ContratAutoId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratAutoId that = (ContratAutoId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
