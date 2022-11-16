package br.com.futurodev.pizzaria.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futurodev.pizzaria.entity.Categoria;
import br.com.futurodev.pizzaria.service.interfaces.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.categoriaService.salvar(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> atualizar(@RequestBody @Valid Categoria categoria){
		return ResponseEntity.ok(this.categoriaService.atualizar(categoria));
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar(){
		return ResponseEntity.ok(this.categoriaService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id){
		return ResponseEntity.ok(this.categoriaService.buscar(id));
	}
	
	@GetMapping("/busca-por-categoria")
	public ResponseEntity<Categoria> buscarPorCategoria(@PathParam("categoria") String categoria){
		return ResponseEntity.ok(this.categoriaService.buscarPorCategoria(categoria));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		
		this.categoriaService.excluir(id);
		
		return ResponseEntity.ok().build();
	}

}