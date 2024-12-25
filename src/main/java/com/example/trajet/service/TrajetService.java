package com.example.trajet.service;

import com.example.trajet.model.Trajet;
import com.example.trajet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrajetService {

    @Autowired
    private TrajetRepository trajetRepository;

    public Trajet saveTrajet(Trajet trajet) {
        return trajetRepository.save(trajet);
    }

    public List<Trajet> getAllTrajets() {
        return trajetRepository.findAll();
    }

    public void deleteTrajet(String id) {
        trajetRepository.deleteById(id);
    }


    // Retourner le total des éléments
    public long getTotalCount() {
        return trajetRepository.count();
    }


}
