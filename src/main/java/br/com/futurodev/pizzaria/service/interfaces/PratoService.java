package br.com.futurodev.pizzaria.service.interfaces;

import br.com.futurodev.pizzaria.entity.Prato;

public interface PratoService extends DefaultCrud<Prato>{

	Prato buscarPorNomePrato(String nomePrato);
	
}
