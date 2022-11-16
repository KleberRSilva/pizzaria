package br.com.futurodev.pizzaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futurodev.pizzaria.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	//se existir uma categoria com o nome informado como paramentro, retorna true
	boolean existsBycategoria(String categoria);
	
	//funcao para buscar a descricao recebida como parametro
	Optional<Categoria> findByCategoria(String categoria);
}