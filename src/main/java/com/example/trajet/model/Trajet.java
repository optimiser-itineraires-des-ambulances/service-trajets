package com.example.trajet.model;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "trajets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trajet {

    @Id
    private String id;

    private Map<String,Double> pointDepart;

    private Map<String,Double> pointArrivee;

    //private Long intervention_id;
    @Column(name = "hopital_id", nullable = false)
    private Long hopital_id;

    /*@Transient
    @ManyToOne
    private Intervention intervention;
*/

    @Transient
    @ManyToOne
    private Hopital hopital;
}
