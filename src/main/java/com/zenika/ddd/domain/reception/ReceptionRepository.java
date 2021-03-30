package com.zenika.ddd.domain.reception;

public interface ReceptionRepository {
    Reception find(ReceptionId receptionId);

    void save(Reception reception);
}
