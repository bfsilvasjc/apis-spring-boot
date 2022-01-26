package com.teste.tecnico5.teste5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "veiculo")
public class VeiculoModel {
	
	public VeiculoModel(String veiculo, String marca, int ano, String descricao, Boolean vendido, Date created, Date updated) {
       this.setVeiculo(veiculo);
       this.setMarca(marca);
       this.setAno(ano);
       this.setDescricao(descricao);
       this.setVendido(vendido);
       this.setCreated(created);
       this.setUpdated(updated);
    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veiculo;
	
	@Column(nullable = false, length = 30)
    private String veiculo;

    @Column(nullable = false, length = 30)
    private String marca;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false, length = 50)
    private String descricao;

    @Column(nullable = false)
    private Boolean vendido;

    @Column(nullable = false)
    private Date created;
    
    @Column(nullable = false)
    private Date updated;
}
