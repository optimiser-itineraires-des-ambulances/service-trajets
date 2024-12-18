package com.example.trajet.service;

import com.example.trajet.model.Trajet;
import com.example.trajet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
