package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabletest")
public class Collegue {

    @Id
    private String matricule;
    private String nom;
    private String prenoms;
    private String email;
    private LocalDate dateDeNaissance;
    private String photoUrl;

    public Collegue() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Collegue(String matricule, String nom, String prenoms, String email, LocalDate dateDeNaissance,
            String photoUrl) {
        super();
        this.matricule = matricule;
        this.nom = nom;
        this.prenoms = prenoms;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.photoUrl = photoUrl;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
