package com.epsi.mspr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plantes")
public class Plante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plante", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "type", length = 100)
    private String type;

    @Lob
    @Column(name = "instructions_soin")
    private String instructionsSoin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur idUtilisateur;

    @OneToMany(mappedBy = "idPlante")
    private Set<Conseil> conseils = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idPlante")
    private Set<SessionsGarde> sessionsGardes = new LinkedHashSet<>();

}