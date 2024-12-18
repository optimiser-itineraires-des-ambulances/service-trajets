package com.example.trajet.controller;

import com.example.trajet.model.Trajet;
import com.example.trajet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trajet")
public class TrajetController {

    @Autowired
    private TrajetRepository trajetRepository;

    @PostMapping("/add")
    public ResponseEntity<Trajet> createTrajet(@RequestBody Trajet trajet) {
        if (trajet == null) {
            return ResponseEntity.badRequest().build();
        }
        Trajet savedTrajet = trajetRepository.save(trajet);
        return ResponseEntity.ok(savedTrajet);
    }

    @GetMapping("/all")
    public List<Trajet> getAll(){
        return trajetRepository.findAll();
    }
}


