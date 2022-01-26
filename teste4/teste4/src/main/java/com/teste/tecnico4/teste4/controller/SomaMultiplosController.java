package com.teste.tecnico4.teste4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teste.tecnico4.teste4.service.SomaMultiplosService;

@RestController
public class SomaMultiplosController {

	@GetMapping(path = "/api/somaMultiplos/{limite}")
	public long somaMultiplos(@PathVariable("limite") long limite){
		
		SomaMultiplosService service = new SomaMultiplosService();
		
		long soma = service.somar(limite);
		
		return soma;
	}
}
