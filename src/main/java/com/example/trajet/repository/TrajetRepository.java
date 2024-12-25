package com.example.trajet.repository;

import com.example.trajet.model.Trajet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajetRepository extends MongoRepository<Trajet,String> {

    //List<Trajet> findTop5ByOrderByDistanceDesc();
}
