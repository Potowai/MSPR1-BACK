package com.epsi.mspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {
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

    @Column(name = "role")
    private String role;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @Column(name = "botaniste")
    private Boolean botaniste;

    @OneToOne(mappedBy = "utilisateur")
    private Adresse adresse;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private Set<Experience> experiences = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private Set<Plante> plantes = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private Set<SessionsGarde> sessionsGardes = new LinkedHashSet<>();

}