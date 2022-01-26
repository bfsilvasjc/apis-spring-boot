package com.teste.tecnico.teste.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PercentualResponseModel {
	
	private double votosValidos;
	
	private double votosBrancos;
	
	private double votosNulos;
}
