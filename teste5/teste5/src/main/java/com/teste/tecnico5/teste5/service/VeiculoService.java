package com.teste.tecnico5.teste5.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.tecnico5.teste5.model.VeiculoModel;
import com.teste.tecnico5.teste5.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	VeiculoRepository repository;
	
	public List<VeiculoModel> listarVeiculos(){
		return repository.findAll();
	}
	
	public VeiculoModel buscarPorId(Integer id_veiculo) {
		return repository.buscarPorId(id_veiculo);
	}
	
	public List<VeiculoModel> buscarPorTermo(String marca, String ano) {
		return repository.buscarPorTermo(marca, ano);
	}
	
	public VeiculoModel cadastrarVeiculo(VeiculoModel veiculo) {
		return repository.save(veiculo);
	}
	
	public VeiculoModel atualizarVeiculo(VeiculoModel veiculo) {
		return repository.save(veiculo);
	}
	
	public void deletarVeiculo(Integer id_veiculo) {
		repository.deletarPorId(id_veiculo);
	}
	
	public Integer qtdNaoVendidos() {
		
		List<VeiculoModel> lista = repository.qtdNaoVendidos();
		
		Integer qtd = lista.size();
		
		return qtd; 
	}
	
	public Integer qtdPorDecada(Integer decada) {
		
		List<VeiculoModel> listaVeiculos = repository.veiculosPorDecada((int) (decada / 10 * 10), (int) (decada / 10 * 10 + 9));
		
		Integer qtd = listaVeiculos.size();
		
		return qtd;
	}
	
	public Integer regUltimaSemana() {
		
		Date hoje = new Date();
		
		List<VeiculoModel> lista = repository.regUltimaSemana(new Date(hoje.getTime() - (1000 * 60 * 60 * 24 * 7)), hoje);
		
		Integer qtd = lista.size();
		
		return qtd;
	}
}
