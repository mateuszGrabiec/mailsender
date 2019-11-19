package net.usermd.grabiecm.mailsender.controller;

import net.usermd.grabiecm.mailsender.model.CatFact;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    public CatFact getCatFact() {
        RestTemplate restTemplate = new RestTemplate();
        CatFact catFact;
        catFact = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", CatFact.class);
        return catFact;
    }
}
