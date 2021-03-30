package com.zenika.ddd.api.reception;

import com.zenika.ddd.application.reception.ReceptionLifecycleApplicationService;
import com.zenika.ddd.domain.reception.IdExpedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceptionApi {

    ReceptionLifecycleApplicationService service;

    public ReceptionApi(ReceptionLifecycleApplicationService service) {
        this.service = service;
    }

    @PostMapping("/reception")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatReception(@RequestBody CreerReceptionDto creerReceptionDto) {
        service.creerReception(new IdExpedition(creerReceptionDto.getExpedition()));
    }
}
