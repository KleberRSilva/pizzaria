package br.com.futurodev.pizzaria.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futurodev.pizzaria.entity.Prato;
import br.com.futurodev.pizzaria.service.interfaces.PratoService;

@RestController
@RequestMapping("/pratos")
public class PratoController {
	
	@Autowired
	private PratoService pratoService;
	
	@PostMapping
	public ResponseEntity<Prato> salvar(@RequestBody Prato prato){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.pratoService.salvar(prato));
	}
	
	@GetMapping
	public ResponseEntity<List<Prato>> listar(){
		return ResponseEntity.ok(this.pratoService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prato> buscar(@PathVariable Long id){
		return ResponseEntity.ok(this.pratoService.buscar(id));
	}
	
	@GetMapping("/buscar-por-nomeprato")
	public ResponseEntity<Prato> buscarPorNomePrato(@PathParam("nomePrato") String nomePrato){
		return ResponseEntity.ok(this.pratoService.buscarPorNomePrato(nomePrato));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		this.pratoService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
