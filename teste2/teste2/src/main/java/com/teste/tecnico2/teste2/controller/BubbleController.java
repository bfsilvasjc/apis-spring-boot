package com.teste.tecnico2.teste2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.tecnico2.teste2.service.BubbleService;

@RestController
public class BubbleController {

	@Autowired
	BubbleService service;
	
	@RequestMapping(path = "/sort/{array}", method = RequestMethod.GET)
    public List<Integer> veiculos(@PathVariable("array") List<Integer> array) {
		
		List<Integer> arrayOrdenado = service.sort(array);
		
        return arrayOrdenado;
    }
}
