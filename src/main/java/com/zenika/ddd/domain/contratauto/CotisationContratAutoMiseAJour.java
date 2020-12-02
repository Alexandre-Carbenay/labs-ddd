package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.domain.aggregate.AggregateSpecificEvent;
import com.zenika.ddd.domain.event.Event;

import java.util.Objects;

public class CotisationContratAutoMiseAJour implements Event, AggregateSpecificEvent {

    private final ContratAutoId contratAutoId;
    private final Montant ancienneCotisation;
    private final Montant nouvelleCotisation;

    public CotisationContratAutoMiseAJour(ContratAutoId contratAutoId, Montant ancienneCotisation, Montant nouvelleCotisation) {
        this.contratAutoId = contratAutoId;
        this.ancienneCotisation = ancienneCotisation;
        this.nouvelleCotisation = nouvelleCotisation;
    }

    public ContratAutoId getContratAutoId() {
        return contratAutoId;
    }

    public Montant getAncienneCotisation() {
        return ancienneCotisation;
    }

    public Montant getNouvelleCotisation() {
        return nouvelleCotisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CotisationContratAutoMiseAJour that = (CotisationContratAutoMiseAJour) o;
        return Objects.equals(contratAutoId, that.contratAutoId) &&
                Objects.equals(ancienneCotisation, that.ancienneCotisation) &&
                Objects.equals(nouvelleCotisation, that.nouvelleCotisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contratAutoId, ancienneCotisation, nouvelleCotisation);
    }
}
