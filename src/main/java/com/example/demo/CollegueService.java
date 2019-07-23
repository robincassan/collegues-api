package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CollegueService {

    private Map<String, Collegue> data = new HashMap<>();

    public List<Collegue> rechercherParNom(String nomRecherche) {
        // TODO retourner une liste de collègues dont le nom est fourni

        // creation de la liste qui recupérera les noms recherchés
        List<Collegue> nom = new ArrayList<Collegue>();

        Set<Entry<String, Collegue>> listeEntries = data.entrySet();

        for (Entry<String, Collegue> entry : listeEntries) {

            String matricule = entry.getKey();
            Collegue collegue = entry.getValue();
            if (nomRecherche.equals(collegue.getNom())) {
                nom.add(collegue);
            }

        }
        return nom;
    }

    public Collegue rechercherParMatricule(String matriculeRecherche) {
        // TODO retourner le collègue dont le matricule est fourni

        // creation de la liste qui recupérera les noms recherchés

        Set<Entry<String, Collegue>> listeEntries = data.entrySet();

        for (Entry<String, Collegue> entry : listeEntries) {
            String matricule = entry.getKey();
            Collegue collegue = entry.getValue();
            if (matriculeRecherche.equals(matricule)) {
                return collegue;
            }

        }
        // TODO retourner une exception `CollegueNonTrouveException` (à créer)
        // si le matricule ne correspond à aucun collègue

        throw new ColleguesNonTrouveException();

    }

    public Collegue modifierCollegue(Collegue collegue, String matricule) {
        Collegue col = rechercherParMatricule(matricule);
        col.setEmail(collegue.getEmail());
        col.setPhotoUrl(collegue.getPhotoUrl());
        data.put(matricule, col);
        return col;

    }

}
