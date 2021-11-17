package com.zenika.ddd.exemples;

public class Class1 {

    private Class2 class2;

    public Class1(Class2 class2) {
        this.class2 = class2;
    }

    public void doSomething() {
        class2.doSomethingElse();
    }

}
