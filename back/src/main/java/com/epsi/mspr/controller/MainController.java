package com.epsi.mspr.controller;

import com.epsi.mspr.entity.Plante;
import com.epsi.mspr.repository.PlanteRepository;
import com.epsi.mspr.service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private PlanteService planteService;

    @GetMapping("/map")
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        return map;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/plantes")
    public List<Plante> getPlantes() {
        return planteService.getPlantes();
    }
}
