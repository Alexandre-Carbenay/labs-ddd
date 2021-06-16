package com.zenika.ddd.pickingcommandeclient.infrastructure.gateway.adressedestockage;

import com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse.AdresseDeStockage;
import com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse.AdresseDeStockageGateway;
import com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse.ProduitId;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestApiAdresseDeStockageGateway implements AdresseDeStockageGateway {

    RestTemplate restTemplate;

    @Override
    public AdresseDeStockage getAdresseDuProduit(ProduitId id) {
        AdresseDto dto = restTemplate.getForEntity("/adresse_de_stock/{id}", id);
        return dto.translateToAdresseDeStockage();
    }
}
