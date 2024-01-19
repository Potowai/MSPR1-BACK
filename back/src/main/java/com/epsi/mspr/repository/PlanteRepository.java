package com.epsi.mspr.repository;

import com.epsi.mspr.entity.Plante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanteRepository extends JpaRepository<Plante, Integer> {
    Plante findPlanteByNom(String nom);
}