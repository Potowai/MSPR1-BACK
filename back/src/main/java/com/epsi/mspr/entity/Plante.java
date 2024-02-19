package com.epsi.mspr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plantes")
public class Plante implements Serializable {
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

    @Lob
    @Column(name = "imageUrl")
    private Blob imageData;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
    @JsonIgnore
    @OneToMany(mappedBy = "plante")
    private Set<Conseil> conseils = new LinkedHashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "plante")
    private Set<SessionsGarde> sessionsGardes = new LinkedHashSet<>();
}