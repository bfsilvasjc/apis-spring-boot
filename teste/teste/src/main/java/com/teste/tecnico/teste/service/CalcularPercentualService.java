package com.teste.tecnico.teste.service;

import org.springframework.stereotype.Service;

import com.teste.tecnico.teste.model.CalcularPercentualModel;
import com.teste.tecnico.teste.model.PercentualResponseModel;

@Service
public class CalcularPercentualService {
	
	CalcularPercentualModel calcModel;

	public CalcularPercentualService() {
		calcModel = new CalcularPercentualModel();
	}
	
	public PercentualResponseModel calcular() {
		return new PercentualResponseModel(
				calcularVotosValidos(),
				calcularVotosBrancos(),
				calcularVotosNulos()
				);
	}
	
	public double calcularVotosValidos() {
		return calcModel.getVotosValidos() / calcModel.getVotosValidos();
	}
	
	public double calcularVotosBrancos() {
		return calcModel.getVotosValidos() / calcModel.getVotosBrancos();
	}
	
	public double calcularVotosNulos() {
		return calcModel.getVotosValidos() / calcModel.getVotosNulos();
	}
}
