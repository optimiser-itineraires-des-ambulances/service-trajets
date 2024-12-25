package com.example.trajet;

import com.example.trajet.model.Hopital;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-HOPITAUX")
public interface HopitalService {
    @GetMapping("/hopitaux/{id}")
    Hopital getHopitalById(@PathVariable Long id);

}
