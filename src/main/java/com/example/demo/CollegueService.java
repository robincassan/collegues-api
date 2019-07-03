package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class CollegueService {

    private Map<String, Collegue> data = new HashMap<>();

    public CollegueService() {
        Collegue col1 = new Collegue();
        Collegue col2 = new Collegue();
        Collegue col3 = new Collegue();
        Collegue col4 = new Collegue();

        col1.setMatricule(UUID.randomUUID().toString());
        col1.setEmail("robin.cassan@diginamic.fr");
        col1.setDateDeNaissance(LocalDate.of(1992, 9, 11));
        col1.setNom("Cassan");
        col1.setPrenoms("Robin");
        col1.setPhotoUrl("photo." + col1.getNom() + col1.getPrenoms());

        col2.setMatricule(UUID.randomUUID().toString());
        col2.setEmail("rossy.oddet@diginamic.fr");
        col2.setDateDeNaissance(LocalDate.of(1982, 05, 15));
        col2.setNom("Oddet");
        col2.setPrenoms("Rossy");
        col2.setPhotoUrl("photo." + col2.getNom() + col2.getPrenoms());

        col3.setMatricule(UUID.randomUUID().toString());
        col3.setEmail("JB.TM@diginamic.fr");
        col3.setDateDeNaissance(LocalDate.of(1990, 06, 30));
        col3.setNom("MATHIEU");
        col3.setPrenoms("Jean Baptiste");
        col3.setPhotoUrl("photo." + col3.getNom() + col3.getPrenoms());

        col4.setMatricule(UUID.randomUUID().toString());
        col4.setEmail("JB.TM@diginamic.fr");
        col4.setDateDeNaissance(LocalDate.of(1990, 06, 30));
        col4.setNom("MATHIEU");
        col4.setPrenoms("Jean Baptiste");
        col4.setPhotoUrl("photo." + col4.getNom() + col4.getPrenoms());

        data.put(col1.getMatricule(), col1);
        data.put(col2.getMatricule(), col2);
        data.put(col3.getMatricule(), col3);
        data.put(col4.getMatricule(), col4);

    }

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

}
