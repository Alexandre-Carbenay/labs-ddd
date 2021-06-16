package com.zenika.ddd.pickingcommandeclient.exposition.cheminderamasse;

import com.zenika.ddd.pickingcommandeclient.application.cheminderamasse.CheminDeRamasseAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheminDeRamasseController {

    private CheminDeRamasseAppService cheminDeRamasseAppService;

    @GetMapping("/chemins_de_ramasse")
    List<CheminDeRamasseDto> getCheminsDeRamasse() {
        return cheminDeRamasseAppService.getCheminsDeRamasse();
    }

}
