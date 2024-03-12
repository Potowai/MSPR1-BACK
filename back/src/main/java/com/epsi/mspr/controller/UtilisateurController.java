package com.epsi.mspr.controller;

import com.epsi.mspr.entity.Utilisateur;
import com.epsi.mspr.repository.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UtilisateurController {
    private UtilisateurRepository utilisateurRepository;

    private PasswordEncoder passwordEncoder;

    public UtilisateurController(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
    }

    @PostMapping("/register")
    public Utilisateur registerUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return utilisateurRepository.save(utilisateur);
    }

    @PostMapping("/login")
    public boolean loginUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.findByEmail(utilisateur.getEmail()).map(user -> passwordEncoder.matches(utilisateur.getMotDePasse(), user.getMotDePasse())).orElse(false);
    }
}
