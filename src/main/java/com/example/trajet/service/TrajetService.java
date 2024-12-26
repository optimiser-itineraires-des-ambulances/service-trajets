package com.example.trajet.service;

import com.example.trajet.model.Trajet;
import com.example.trajet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrajetService {

    @Autowired
    private TrajetRepository trajetRepository;

    // Rayon de la Terre en kilomètres
    private static final double EARTH_RADIUS = 6371;


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



    // Méthode pour calculer la distance entre deux points géographiques
    private double calculateDistance(Map<String, Double> point1, Map<String, Double> point2) {
        double lat1 = Math.toRadians(point1.get("latitude"));
        double lon1 = Math.toRadians(point1.get("longitude"));
        double lat2 = Math.toRadians(point2.get("latitude"));
        double lon2 = Math.toRadians(point2.get("longitude"));

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c; // Distance en kilomètres
    }

    // Méthode pour obtenir les trajets avec leur distance calculée à la volée
    public List<Map<String, Object>> getTrajetsWithDistances() {
        List<Trajet> trajets = trajetRepository.findAll();
        List<Map<String, Object>> trajetsWithDistances = new ArrayList<>();

        for (Trajet trajet : trajets) {
            if (trajet.getPointDepart() != null && trajet.getPointArrivee() != null) {
                double distance = calculateDistance(trajet.getPointDepart(), trajet.getPointArrivee());

                Map<String, Object> trajetWithDistance = new HashMap<>();
                trajetWithDistance.put("id", trajet.getId());
                trajetWithDistance.put("distance", distance);
                trajetWithDistance.put("pointDepart", trajet.getPointDepart());
                trajetWithDistance.put("pointArrivee", trajet.getPointArrivee());
                trajetWithDistance.put("hopital_id", trajet.getHopital_id());
                trajetsWithDistances.add(trajetWithDistance);
            }
        }

        return trajetsWithDistances;
    }



}
