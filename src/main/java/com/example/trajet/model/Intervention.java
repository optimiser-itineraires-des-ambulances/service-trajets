package com.example.trajet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intervention {

    @Id
    private String id;
    private LocalDateTime date;
    private Map<String, Double> localisation;
    private String gravite;
}
