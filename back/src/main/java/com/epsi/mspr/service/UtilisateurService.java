package com.epsi.mspr.service;

import com.epsi.mspr.entity.Utilisateur;
import com.epsi.mspr.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(null);
    }

    public String getUtilisateurRole(String email) {
        return utilisateurRepository.findByEmail(email).orElse(null).getRole();
    }
}
