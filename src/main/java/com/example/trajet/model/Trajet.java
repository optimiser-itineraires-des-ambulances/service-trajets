package com.example.trajet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trajets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trajet {

    @Id
    private String id;



}
