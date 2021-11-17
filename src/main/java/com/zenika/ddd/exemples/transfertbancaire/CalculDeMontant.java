package com.zenika.ddd.exemples.transfertbancaire;

public class CalculDeMontant {

    public void doSomething() {
        Montant a = new Montant(3);
        Montant b = new Montant(4);
        Montant c = a.additionne(b);
    }

}
