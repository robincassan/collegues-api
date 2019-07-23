package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ColleguesApiApplication {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CollegueRepository collegueRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

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

        // stockage dans la base de données

        collegueRepository.save(col1);
        collegueRepository.save(col2);
        collegueRepository.save(col3);
        collegueRepository.save(col4);

        // Chiffrage des mots de passe avant insertion en base de données
        utilisateurRepository.save(
                new Utilisateur("u1", passwordEncoder.encode("pass1"), col1, Arrays.asList("ROLE_ADMIN", "ROLE_USER")));
        utilisateurRepository
                .save(new Utilisateur("u2", passwordEncoder.encode("pass2"), col2, Arrays.asList("ROLE_USER")));

    }

    public static void main(String[] args) {
        SpringApplication.run(ColleguesApiApplication.class, args);
    }

}
