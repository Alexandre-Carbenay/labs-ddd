package com.zenika.ddd.domain.reception;

public class Sku {
    private final String value;

    public Sku(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		return (value.equals(other.value));

	}
}
