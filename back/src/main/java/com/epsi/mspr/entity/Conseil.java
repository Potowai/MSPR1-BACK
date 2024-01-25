package com.epsi.mspr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conseils")
public class Conseil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conseil", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "contenu")
    private String contenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_botaniste", referencedColumnName = "id_utilisateur")
    private Botaniste idBotaniste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plante")
    private Plante idPlante;

}