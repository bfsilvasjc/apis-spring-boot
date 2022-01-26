package com.teste.tecnico3.teste3.service;

import org.springframework.stereotype.Service;

@Service
public class FatorialService {
	 public long fatorial(long n) {
		 return ((n <= 1) ? 1 : n * fatorial(n - 1));
	 }
}
