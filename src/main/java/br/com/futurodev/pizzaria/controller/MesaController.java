package br.com.futurodev.pizzaria.controller;

import java.util.List;

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

import br.com.futurodev.pizzaria.entity.Mesa;
import br.com.futurodev.pizzaria.service.interfaces.MesaService;

@RestController
@RequestMapping("/mesas")
public class MesaController {
	
	@Autowired
	MesaService mesaService;
	
	@PostMapping
	public ResponseEntity<Mesa> salvar(@RequestBody Mesa mesa) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.mesaService.salvar(mesa));
	}
	
	@PutMapping
	public ResponseEntity<Mesa> atualizar(@RequestBody Mesa mesa){
		return ResponseEntity.ok(this.mesaService.atualizar(mesa));
	}
	
	@GetMapping
	public ResponseEntity<List<Mesa>> listar(){
		return ResponseEntity.ok(this.mesaService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mesa> buscar(@PathVariable Long id){
		
		Mesa mesa = this.mesaService.buscar(id);
		
		if (mesa == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.mesaService.buscar(id));
	}
	
	@GetMapping("/ativas")
	public ResponseEntity<List<Mesa>> ListarAtivar(){
		return ResponseEntity.ok(this.mesaService.listarAtivas());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id){
		this.mesaService.excluir(id);
		
		return ResponseEntity.ok("Excluido com sucesso!");
	}

}
