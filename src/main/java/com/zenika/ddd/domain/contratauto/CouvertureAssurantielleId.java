package com.zenika.ddd.domain.contratauto;

import java.util.Objects;

public class CouvertureAssurantielleId {

    private final String id;

    public CouvertureAssurantielleId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouvertureAssurantielleId that = (CouvertureAssurantielleId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
