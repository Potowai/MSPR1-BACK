package com.epsi.mspr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Lob
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "idUtilisateur")
    private Set<Botaniste> botanistes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUtilisateur")
    private Set<Plante> plantes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGardien")
    private Set<SessionsGarde> sessionsGardes = new LinkedHashSet<>();

}