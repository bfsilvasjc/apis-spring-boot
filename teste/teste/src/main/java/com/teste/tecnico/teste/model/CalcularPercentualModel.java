package com.teste.tecnico.teste.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcularPercentualModel {
	
	private Integer votosTotais;

	private Integer votosValidos;

    private Integer votosBrancos;
    
    private Integer votosNulos;
    
    public CalcularPercentualModel() {
		votosTotais = 1000;
		votosValidos = 800;
		votosBrancos = 150;
		votosNulos = 50;
	}
}
