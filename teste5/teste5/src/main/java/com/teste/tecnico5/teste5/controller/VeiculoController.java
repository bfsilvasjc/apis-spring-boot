package com.teste.tecnico5.teste5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.tecnico5.teste5.model.VeiculoModel;
import com.teste.tecnico5.teste5.service.VeiculoService;

@RestController
public class VeiculoController {
	
	@Autowired
	VeiculoService service;
	
	@RequestMapping(path = "/veiculos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VeiculoModel> veiculos() {
		
		List<VeiculoModel> listaVeiculos = service.listarVeiculos();
		
        return listaVeiculos;
    }

	@RequestMapping(path = "/veiculos/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VeiculoModel> find(@RequestParam(name = "marca") String marca, @RequestParam(name = "ano") String ano){
        return service.buscarPorTermo(marca, ano);
    }
	
	@RequestMapping(path = "/veiculos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public VeiculoModel buscarPorId(@RequestParam("id") Integer id_veiculo){
        return service.buscarPorId(id_veiculo);
    }
	
	@RequestMapping(path = "/veiculos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public VeiculoModel cadastrarVeiculo(@RequestBody VeiculoModel veiculo) {
		
		VeiculoModel veiculoCadastrado = service.cadastrarVeiculo(veiculo);
		
        return veiculoCadastrado;
    }
	
	@RequestMapping(path = "/veiculos", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public VeiculoModel atualizarVeiculo(@RequestBody VeiculoModel veiculo) {
		
		VeiculoModel veiculoAtualizado = service.atualizarVeiculo(veiculo);
		
        return veiculoAtualizado;
    }
	/*
	@RequestMapping(path = "/veiculos", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public VeiculoModel cadastrarVeiculo(@RequestBody VeiculoModel veiculo) {
		
		VeiculoModel veiculoCadastrado = service.cadastrarVeiculo(veiculo);
		
        return veiculoCadastrado;
    }
	*/
	@RequestMapping(path = "/veiculos", method = RequestMethod.DELETE)
    public void deletarVeiculo(@RequestParam("id") Integer id_veiculo) {
		
		service.deletarVeiculo(id_veiculo);

    }
	
	@RequestMapping(path = "/veiculos/naoVendidos", method = RequestMethod.GET)
    public Integer qtdVeiculosNaoVendidos() {
		
		Integer qtdVeiculos = service.qtdNaoVendidos();
		
        return qtdVeiculos;
    }
	
	@RequestMapping(path = "/veiculos/qtdPorDecada/{decada}", method = RequestMethod.GET)
    public Integer qtdPorDecada(@RequestParam("decada") Integer decada) {
		
		Integer qtdPorDecada = service.qtdPorDecada(decada);
		
        return qtdPorDecada;
    }
	
	@RequestMapping(path = "/veiculos/regUltimaSemana/", method = RequestMethod.GET)
    public Integer regUltimaSemana() {
		
		Integer regUltimaSemana = service.regUltimaSemana();
		
        return regUltimaSemana;
    }
}
