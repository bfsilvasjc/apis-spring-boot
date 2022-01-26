package com.teste.tecnico.teste.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.teste.tecnico.teste.model.PercentualResponseModel;
import com.teste.tecnico.teste.service.CalcularPercentualService;

@RestController
public class CalculaPercentualController {

    @GetMapping(path = "/api/calcPercentual", produces = MediaType.APPLICATION_JSON_VALUE)
    public PercentualResponseModel calcularPercentual(){
    	
    	CalcularPercentualService service = new CalcularPercentualService();
        
    	return service.calcular();
    }
}
