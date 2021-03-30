package com.zenika.ddd.domain.reception;

import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

public class AvisExpedition {
    private final EnteteAvisExpedition entete;
    private final List<Marchandise> lignes;

    public AvisExpedition(EnteteAvisExpedition entete, List<Marchandise> lignes) {
        Assert.notNull(entete);
        Assert.notEmpty(lignes);

        this.entete = entete;
        this.lignes = Collections.unmodifiableList(lignes);
    }

	public boolean contientLigne(Marchandise marchandise) {
		
		return lignes.stream().anyMatch(ligne -> ligne.avecMemeSku(marchandise.getSKU()));
		
	}
}
