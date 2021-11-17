package com.zenika.ddd.exemples.family;

import java.util.Collections;
import java.util.List;

public class Parent {

    private List<Child> children;

    public List<Child> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void reconnaitEnfant(Child child) {
        if (jeConnaisDejaLenfant) {

        }
    }

    public boolean isGrandParent(Child child) {
        for (Child myChild : children) {
            myChild.getChildren().add()
            if (myChild.isParentOf(child)) {
//            if (myChild.getChildren().contains(child)) {
                return true;
            }
        }
        return false;
    }

}
