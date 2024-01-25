package com.epsi.mspr.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions_garde")
public class SessionsGarde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plante")
    private Plante idPlante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gardien")
    private Utilisateur idGardien;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Lob
    @Column(name = "commentaires")
    private String commentaires;

}