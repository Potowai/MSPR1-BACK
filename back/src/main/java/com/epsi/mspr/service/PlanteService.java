package com.epsi.mspr.service;

import com.epsi.mspr.entity.Plante;
import com.epsi.mspr.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService {
    @Autowired
    private PlanteRepository planteRepository;

    public Plante getPlanteByName(String name) {
        return planteRepository.findPlanteByNom(name);
    }

    public Plante getPlante(Integer id) {
        return planteRepository.findById(id).get();
    }

    public List<Plante> getPlantes() {
        return planteRepository.findAll();
    }
}
