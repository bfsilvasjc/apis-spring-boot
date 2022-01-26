package com.teste.tecnico5.teste5.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.teste.tecnico5.teste5.AbstractControllerTest;
import com.teste.tecnico5.teste5.model.VeiculoModel;

@Transactional
public class VeiculoControllerTest extends AbstractControllerTest {
	
	@Before
    public void setUp() {
        super.setUp();
    }
	
	@Test
    public void testListarVeiculos() throws Exception {
        String uri = "/veiculos";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals(status, 200);
        Assert.assertNotNull(content);
    }
	
	@Test
    public void testConsultarVeiculo() throws Exception {
        String uri = "/veiculos/{codigo}";
        Integer codigo = 1;

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, codigo)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals(status, 200);
        Assert.assertNotNull(content);
    }

    @Test
    public void testConsultarNotFound() throws Exception {
        String uri = "/veiculos/{codigo}";
        Integer codigo = 0;

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, codigo)).andReturn();

        int status = result.getResponse().getStatus();

        Assert.assertEquals(status, 404);
    }

    @Test
    public void testCadastrarVeiculo() throws Exception {
        String uri = "/veiculos";

        VeiculoModel veiculoModel = new VeiculoModel(
				 "Exemplo",
				 "Hyundai",
				 2012,
				 "Descrição de exemplo",
				 Boolean.TRUE,
				 new Date(),
				 new Date()
		);

        String inputJson = super.mapToJson(veiculoModel);

        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assert.assertEquals(status, 200);

        String content = result.getResponse().getContentAsString();
        VeiculoModel veiculoModelCriado = super.mapFromJson(content, VeiculoModel.class);

        Assert.assertNotNull(veiculoModelCriado);
        Assert.assertEquals(veiculoModel.getVeiculo(), veiculoModelCriado.getVeiculo());
    }

}
