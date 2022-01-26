package com.teste.tecnico5.teste5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teste.tecnico5.teste5.model.VeiculoModel;

@Repository
@Transactional
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {
	
	@Query(value = "SELECT * FROM veiculo WHERE id_veiculo = :id_veiculo", nativeQuery = true)
	public VeiculoModel buscarPorId(@Param("id_veiculo") Integer id_veiculo);
	
	@Query(value = "SELECT * FROM veiculo WHERE veiculo = :termo OR marca = :termo", nativeQuery = true)
	public List<VeiculoModel> buscarPorTermo(@Param("termo") String termo);
	
	@Modifying
	@Query("DELETE FROM veiculo WHERE id_veiculo = :id_veiculo")
	public void deletarPorId(@Param("id_veiculo") Integer id_veiculo);
	
}
