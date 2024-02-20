package com.epsi.mspr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adresse")
public class Adresse implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rue", length = 100)
    private String rue;

    @Column(name = "ville", length = 100)
    private String ville;

    @Column(name = "code_postal", length = 100)
    private String codePostal;

    @Column(name = "pays", length = 100)
    private String pays;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

}
