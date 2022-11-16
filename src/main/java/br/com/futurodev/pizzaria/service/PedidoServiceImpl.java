package br.com.futurodev.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futurodev.pizzaria.entity.Pedido;
import br.com.futurodev.pizzaria.repository.PedidoRepository;
import br.com.futurodev.pizzaria.service.interfaces.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido salvar(Pedido pedido) {
		return this.pedidoRepository.save(pedido);
	}

	@Override
	public Pedido atualizar(Pedido object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
	}

}
