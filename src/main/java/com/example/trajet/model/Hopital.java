package com.example.trajet.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hopital {

    @Id
    private Long id;
    private String nom;
    private String adresse;
    private Double latitude;
    private Double longitude;
    private boolean disponible;
}
