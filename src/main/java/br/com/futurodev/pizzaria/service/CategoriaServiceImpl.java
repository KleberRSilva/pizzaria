package br.com.futurodev.pizzaria.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futurodev.pizzaria.entity.Categoria;
import br.com.futurodev.pizzaria.repository.CategoriaRepository;
import br.com.futurodev.pizzaria.service.interfaces.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria salvar(Categoria categoria) {
		
		String nomeCategoria = categoria.getCategoria().toUpperCase();
		validarCategoria(nomeCategoria);
		categoria.setCategoria(nomeCategoria);

		//save rows in the database
		return this.categoriaRepository.save(categoria);
	}

	@Override
	public Categoria atualizar(Categoria categoria) {
		//atualiza status da Categoria no Banco de Dados passando pelo Repository
		Categoria categoriaPesquisada =  buscar(categoria.getId());
		
		if (Objects.nonNull(categoria)) {
			
			categoria.setCategoria(categoria.getCategoria().toUpperCase());
			
			BeanUtils.copyProperties(categoria, categoriaPesquisada,"id");
			
			validarCategoria(categoriaPesquisada.getCategoria().toUpperCase());
			
			this.categoriaRepository.save(categoriaPesquisada);
		}

		return null;
	}
	
	private void validarCategoria(String descricao) {
		
		if (this.categoriaRepository.existsBycategoria(descricao)) {
			throw new EntityExistsException("Categoria já Existente. Descricao: "+descricao);
		}
	}

	@Override
	public Categoria buscar(Long id) {
		// TODO Auto-generated method stub
		Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(id);
		if (categoriaPesquisada.isEmpty()) {
			throw new EntityNotFoundException("Categoria não Encontrada. ID:"+id);
			}
			return categoriaPesquisada.get();
		}

	@Override
	public List<Categoria> listar() {
		// Listar Categorias implementadas
		return this.categoriaRepository.findAll();
	}

	@Override
	public void excluir(Long id) {
		//Exclui o registro com o id informado no parametro
		this.categoriaRepository.deleteById(id);
	}

	@Override
	public Categoria buscarPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findByCategoria(categoria);
		
		if (categoriaPesquisada.isEmpty()) {
			throw new EntityNotFoundException("Categoria: "+ categoriaPesquisada + " Nao localizada");
		}
		
		return categoriaPesquisada.get();
	}

}