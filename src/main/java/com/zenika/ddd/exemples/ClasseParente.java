package com.zenika.ddd.exemples;

public class ClasseParente {

    public ClasseEnfant fonction(ClasseEnfant original) {
        original.changeEtat();
        return new ClasseEnfant();
    }

}
