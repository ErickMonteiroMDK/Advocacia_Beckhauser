package com.advocacia.Advocacia_Beckhauser.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {
    @GetMapping("/heatlh")
    public String healthCheck() {
        return "Aplicação está rodando normalmente";
    }
}
