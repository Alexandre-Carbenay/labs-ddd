package com.zenika.ddd.exemples;

public class Class3 {

    private Interface anInterface;

    public Class3(Interface anInterface) {
        this.anInterface = anInterface;
    }

    public void doSomething() {
        anInterface.doSomethingElse();
    }

}
