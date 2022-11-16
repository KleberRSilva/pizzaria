package br.com.futurodev.pizzaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futurodev.pizzaria.entity.Mesa;
import br.com.futurodev.pizzaria.repository.MesaRepository;
import br.com.futurodev.pizzaria.service.interfaces.MesaService;

@Service
public class MesaServiceImpl implements MesaService{
	
	@Autowired
	MesaRepository mesaRepository;

	@Override
	public Mesa salvar(Mesa mesa) {
		//Envia para o Repository a mesa à salvar
		Mesa mesaSalvar = this.mesaRepository.save(mesa);
		return mesaSalvar;
	}

	@Override
	public Mesa atualizar(Mesa mesa) {
		// atualiza status da mesa no Banco de Dados (passando pelo Repository
		
		Optional<Mesa> mesaPesquisada = this.mesaRepository.findById(mesa.getId());
		
		if (mesaPesquisada.isPresent()) {
			
			mesaPesquisada.get().setStatus(mesa.getStatus());
			
			/*solução pelo Spring
				//BeanUtils.copyProperties(mesa, mesaPesquisada.get(),"id");
			*/
		}
		return this.mesaRepository.save(mesaPesquisada.get());
	}

	@Override
	public Mesa buscar(Long id) {
		// TODO Auto-generated method stub
		Optional<Mesa> mesa = this.mesaRepository.findById(id);
		
		if (mesa.isPresent()) {
			return mesa.get();
		}
		return null;
	}

	@Override
	public List<Mesa> listar() {
		//Lista todas as mesas
		return this.mesaRepository.findAll();
	}
	
	@Override
	public List<Mesa> listarAtivas() {
		//Listar todas as mesas ativas
		List<Mesa> mesas = this.mesaRepository.findAll();
		List<Mesa> mesasAtivas = new ArrayList<>();
		
//		List<Mesa> mesas = this.mesaRepository.findAll()
//				.stream()
//				.filter(mesa -> mesa.getStatus() == true)
//				.collect(Collectors.toList());
//		return mesas;
		
		for (int i = 0; i < mesas.size(); i++) {
			if (mesas.get(i).getStatus() == null) {
			}
			else {
				if (mesas.get(i).getStatus() == true) {
					mesasAtivas.add(mesas.get(i));
				}
			}
		}
		return mesasAtivas;
	}

	@Override
	public void excluir(Long id) {
		//Exclui o Objeto do Banco usando o Spring
		this.mesaRepository.deleteById(id);
		
	}

}
