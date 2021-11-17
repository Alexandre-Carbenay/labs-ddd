package com.zenika.ddd.exemples;

public class Main {

    public static void main(String[] args) {
        Class2 class2 = new Class2();
        Class4 class4 = new Class4();

        Class1 class1 = new Class1(class2);
        Class3 class3 = new Class3(class2);
    }

}
