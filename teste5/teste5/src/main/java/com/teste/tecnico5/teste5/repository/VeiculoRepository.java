package com.teste.tecnico5.teste5.repository;

import java.util.Date;
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
	
	@Query(value = "SELECT * FROM veiculo WHERE marca = :marca OR ano = :ano", nativeQuery = true)
	public List<VeiculoModel> buscarPorTermo(@Param("marca") String marca, @Param("ano") String ano);
	
	@Query(value = "SELECT * FROM veiculo WHERE vendido = 0", nativeQuery = true)
	public List<VeiculoModel> qtdNaoVendidos();
	
	@Query(value = "SELECT * FROM veiculo WHERE ano >= :minimo AND ano < :maximo", nativeQuery = true)
	public List<VeiculoModel> veiculosPorDecada(@Param("minimo") Integer minimo, @Param("maximo") Integer maximo);
	
	@Query(value = "SELECT * FROM veiculo WHERE created > :umaSemanaAtras AND created < :hoje", nativeQuery = true)
	public List<VeiculoModel> regUltimaSemana(@Param("umaSemanaAtras") Date umaSemanaAtras, @Param("hoje") Date hoje);
	
	@Modifying
	@Query("DELETE FROM veiculo WHERE id_veiculo = :id_veiculo")
	public void deletarPorId(@Param("id_veiculo") Integer id_veiculo);
	
}
