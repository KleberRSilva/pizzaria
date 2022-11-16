package br.com.futurodev.pizzaria.service.interfaces;

import java.util.List;

public interface DefaultCrud<T> {
	
	T salvar(T object);
	T atualizar(T object);
	T buscar(Long id);
	List<T> listar();
	void excluir(Long id);
	
}
