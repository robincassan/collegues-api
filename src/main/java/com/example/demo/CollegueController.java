package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collegues")

public class CollegueController {

    private CollegueService collegueService = new CollegueService();

//    GET /collegues?nom=XXX

    @RequestMapping(method = RequestMethod.GET)
    public List<String> recuParamRequete(@RequestParam String nom) {

        List<String> matricules = new ArrayList<>();

        List<Collegue> listeCollegues = collegueService.rechercherParNom(nom);

        for (Collegue collegue : listeCollegues) {

            matricules.add(collegue.getMatricule());

        }

        return matricules;

    }

}
