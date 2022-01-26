package com.teste.tecnico3.teste3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teste.tecnico3.teste3.service.FatorialService;

@RestController
public class FatorialController {
	
	@GetMapping(path = "/api/fatorial/{fatorial}")
	public long fatorial(@PathVariable("fatorial") long fatorial){
		
		FatorialService service = new FatorialService();
		
		long resposta = service.fatorial(fatorial);
		
		return resposta;
	}
}
