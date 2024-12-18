package com.example.trajet.repository;

import com.example.trajet.model.Trajet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends MongoRepository<Trajet,String> {
}
