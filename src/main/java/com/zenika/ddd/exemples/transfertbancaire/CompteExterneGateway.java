package com.zenika.ddd.exemples.transfertbancaire;

public interface CompteExterneGateway {

    void crediter(CompteExterneId id, float montant);

}
