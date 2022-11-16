package br.com.futurodev.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futurodev.pizzaria.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{
	//Sem argumentos
}