package br.com.futurodev.pizzaria.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futurodev.pizzaria.entity.Prato;
import br.com.futurodev.pizzaria.repository.PratoRepository;
import br.com.futurodev.pizzaria.service.interfaces.PratoService;

@Service
public class PratoServiceImpl implements PratoService{

	@Autowired
	private PratoRepository pratoRepository;
	
	@Override
	public Prato salvar(Prato prato) {
		return this.pratoRepository.save(prato);
	}

	@Override
	public Prato atualizar(Prato object) {
		return null;
	}

	@Override
	public Prato buscar(Long id) {
		Optional<Prato> pratoPesquisado = this.pratoRepository.findById(id);
		if (pratoPesquisado.isEmpty()) {
			throw new EntityNotFoundException("Prato  ID: "+ id + " Nao localizado.");
			
		}
		return pratoPesquisado.get();
	}

	@Override
	public List<Prato> listar() {
		return this.pratoRepository.findAll();
	}

	@Override
	public void excluir(Long id) {
		this.pratoRepository.deleteById(id);;
	}

	@Override
	public Prato buscarPorNomePrato(String nomePrato) {
		// TODO Auto-generated method stub
		return this.pratoRepository
				.findByNomePrato(nomePrato)
					.orElseThrow(() -> {
					throw new EntityNotFoundException("Não foi possivel encontrar o prato com o nome: " + nomePrato);
					}
				);
	}

}
