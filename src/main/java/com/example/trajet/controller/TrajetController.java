package com.example.trajet.controller;

import com.example.trajet.HopitalService;
import com.example.trajet.TrajetApplication;
import com.example.trajet.model.Hopital;
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

    @Autowired
    private HopitalService hopitalService;

    @PostMapping("/add/{hopitalId}")
    public ResponseEntity<Trajet> createTrajet(@PathVariable Long hopitalId,@RequestBody Trajet trajet) {
        Hopital hopital = hopitalService.getHopitalById(hopitalId);
        if (hopital == null) {
            return ResponseEntity.badRequest().build();
        }

        if (trajet == null) {
            return ResponseEntity.badRequest().build();
        }
        trajet.setHopital_id(hopitalId);
        Trajet savedTrajet = trajetRepository.save(trajet);
        return ResponseEntity.ok(savedTrajet);
    }

    @GetMapping("/all")
    public List<Trajet> getAll(){
        return trajetRepository.findAll();
    }


}




