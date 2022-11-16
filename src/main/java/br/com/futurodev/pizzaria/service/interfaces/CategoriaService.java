package br.com.futurodev.pizzaria.service.interfaces;

import java.util.List;

import br.com.futurodev.pizzaria.entity.Categoria;

public interface CategoriaService {
	
	Categoria salvar(Categoria categoria);
	Categoria atualizar(Categoria categoria);
	Categoria buscar(Long id);
	Categoria buscarPorCategoria(String categoria);
	List<Categoria> listar();
	void excluir(Long id);
}
