package br.com.futurodev.pizzaria.service.interfaces;

import java.util.List;

import br.com.futurodev.pizzaria.entity.Mesa;

public interface MesaService {
	
	Mesa salvar(Mesa mesa);
	
	Mesa atualizar(Mesa mesa);
	
	Mesa buscar(Long id);
	
	List<Mesa> listar();
	
	void excluir(Long id);

	List<Mesa> listarAtivas();

}