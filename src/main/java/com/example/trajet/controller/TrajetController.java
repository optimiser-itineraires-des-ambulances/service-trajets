package com.example.trajet.controller;

import com.example.trajet.model.Trajet;
import com.example.trajet.repository.TrajetRepository;
import com.example.trajet.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/trajet")
public class TrajetController {

    @Autowired
    private TrajetRepository trajetRepository;
    @Autowired
    private TrajetService trajetService;

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

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalCount() {
        return ResponseEntity.ok(trajetService.getTotalCount());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrajet(@PathVariable String id) {
        trajetService.deleteTrajet(id);
    }

    @GetMapping("/withDistances")
    public List<Map<String, Object>> getTrajetsWithDistances() {
        return trajetService.getTrajetsWithDistances();
    }
}


