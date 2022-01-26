package com.teste.tecnico5.teste5.service;

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
	
	public List<VeiculoModel> buscarPorTermo(String termo) {
		return repository.buscarPorTermo(termo);
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
}
