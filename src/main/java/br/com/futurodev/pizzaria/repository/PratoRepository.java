package br.com.futurodev.pizzaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futurodev.pizzaria.entity.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long>{
	
	Optional<Prato> findByNomePrato(String nomePrato);

}
