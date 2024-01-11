package com.epsi.mspr.entities;
import jakarta.persistence.*;

@Entity
public class Plantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlante;
    private String nom;
    private String type;
    private String instructionSoins;
    private String idUtilisateur;

    public Plantes() {
    }

    public Plantes(int idPlante, String nom, String type, String instructionSoins, String idUtilisateur) {
        this.idPlante = idPlante;
        this.nom = nom;
        this.type = type;
        this.instructionSoins = instructionSoins;
        this.idUtilisateur = idUtilisateur;
    }
}
