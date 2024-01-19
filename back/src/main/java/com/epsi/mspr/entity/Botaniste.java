package com.epsi.mspr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "botanistes")
public class Botaniste {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur idUtilisateur;

    @Column(name = "specialisation", length = 100)
    private String specialisation;

    @Column(name = "annees_experience")
    private Integer anneesExperience;

    @OneToMany(mappedBy = "idBotaniste")
    private Set<Conseil> conseils = new LinkedHashSet<>();

}