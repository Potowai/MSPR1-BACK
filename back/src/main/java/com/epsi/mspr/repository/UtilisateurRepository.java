package com.epsi.mspr.repository;

import com.epsi.mspr.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByNomOrEmail(String nom, String email);
    Optional<Utilisateur> findByNom(String nom);
    Boolean existsByNom(String nom);
    Boolean existsByEmail(String email);
}