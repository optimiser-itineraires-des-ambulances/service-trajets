package com.example.trajet.controller;

import com.example.trajet.HopitalService;
import com.example.trajet.TrajetApplication;
import com.example.trajet.model.Hopital;
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
        trajet.setHopital(hopital);
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

<<<<<<< HEAD
    @GetMapping("/withDistances")
    public List<Map<String, Object>> getTrajetsWithDistances() {
        return trajetService.getTrajetsWithDistances();
    }
=======
    /*@GetMapping("/top5Trajets")
    public ResponseEntity<List<Trajet>> getTop5Trajets() {
        return ResponseEntity.ok(trajetService.getTop5Trajets());
    }*/

>>>>>>> 9bc50b271179b7bab72e1cf3f6104d84b7705e85
}




