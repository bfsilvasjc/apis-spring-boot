package com.teste.tecnico5.teste5.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.teste.tecnico5.teste5.AbstractTest;
import com.teste.tecnico5.teste5.model.VeiculoModel;

public class VeiculoServiceTest extends AbstractTest {
	
	 @Autowired
	 private VeiculoService service;
	 
	 @Test
	 public void testCadastrarVeiculo() {
		 
		 VeiculoModel veiculo = new VeiculoModel(
				 "Exemplo",
				 "Hyundai",
				 2012,
				 "Descrição de exemplo",
				 Boolean.TRUE,
				 new Date(),
				 new Date()
		);
		 
		 VeiculoModel veiculoCadastrado = service.cadastrarVeiculo(veiculo);

		 Assert.assertNotNull(veiculoCadastrado);
		 Assert.assertEquals("Hyundai", veiculoCadastrado.getMarca());
	 }
	 
	 @Test
	 public void testBuscarPorId() {
		 VeiculoModel veiculo = service.buscarPorId(1);

		 Assert.assertNotNull(veiculo);
	 }
	 
	 @Test
	 public void testListarVeiculos() {
		 List<VeiculoModel> lista = service.listarVeiculos();

		 Assert.assertNotNull(lista);
		 Assert.assertTrue(lista.size() > 0);
	 }
	 
	 @Test
	 public void testAtualizarVeiculo() {
		 VeiculoModel veiculo = new VeiculoModel(
				 1,
				 "Exemplo Atualizando",
				 "Hyundai Atualizando",
				 2012,
				 "Descrição de exemplo",
				 Boolean.FALSE,
				 new Date(),
				 new Date()
		);
		 
		 VeiculoModel veiculoAtualizado = service.atualizarVeiculo(veiculo);

		 Assert.assertNotNull(veiculoAtualizado);
		 Assert.assertEquals("Hyundai Atualizando", veiculoAtualizado.getMarca());
	 }
}
