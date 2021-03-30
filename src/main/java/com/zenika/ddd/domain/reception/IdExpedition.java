package com.zenika.ddd.domain.reception;

import java.util.Objects;

public class IdExpedition {

    private final String value;

    public IdExpedition(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdExpedition that = (IdExpedition) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
