package com.zenika.ddd.infrastructure.contratauto;

import com.zenika.ddd.domain.contratauto.ClasseVehicule;
import com.zenika.ddd.domain.contratauto.Immatriculation;
import com.zenika.ddd.domain.contratauto.Vehicule;
import com.zenika.ddd.domain.contratauto.VehiculeGateway;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DumbVehiculeGateway implements VehiculeGateway {

    private List<ClasseVehicule> classes = Arrays.asList(ClasseVehicule.values());
    private Random classeRandom = new Random();

    @Override
    public Vehicule findByImmatriculation(Immatriculation immatriculation) {
        return new Vehicule(immatriculation, classes.get(classeRandom.nextInt(classes.size())));
    }

}
