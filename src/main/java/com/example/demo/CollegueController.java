package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collegues")
@CrossOrigin
public class CollegueController {

    @Autowired
    private CollegueService collegueService;

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

    @RequestMapping(method = RequestMethod.GET, path = "/{matricule}")
    public Collegue getCol(@PathVariable String matricule) {

        return collegueService.rechercherParMatricule(matricule);

    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/{matricule}")
    public Collegue modifCol(@PathVariable String matricule, @RequestBody Collegue collegue) {

        return collegueService.modifierCollegue(collegue, matricule);

    }

}
