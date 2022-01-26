package com.teste.tecnico4.teste4.service;

import org.springframework.stereotype.Service;

@Service
public class SomaMultiplosService {

	public long somar(long limite) {
	
		long soma = 0;
		
		for(int i = 3; i < limite; i++) {
			if(eMultiplo3ou5(i)) {
				soma += i;
			}
		}
		
		return soma;		
	}
	
	private boolean eMultiplo3ou5(long n) {
		return (( n % 3 == 0) || ( n % 5 == 0));
	}
}
