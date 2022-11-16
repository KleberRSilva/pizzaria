package br.com.futurodev.pizzaria.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Mesa mesa;
	
	private Double valorTotal;
	
	
	private Boolean isPago;
	
	@ManyToMany
	@JoinTable(
			name = "pedido_prato",
			joinColumns = @JoinColumn(name = "pedido_id"),
			inverseJoinColumns = @JoinColumn(name = "prato_id")
	)
	private List<Prato> pedidoPrato;
	
	//Metodos
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Boolean getIsPago() {
		return isPago;
	}
	public void setIsPago(Boolean isPago) {
		this.isPago = isPago;
	}
	public List<Prato> getPedidoPrato() {
		return pedidoPrato;
	}
	public void setPedidoPrato(List<Prato> pedidoPrato) {
		this.pedidoPrato = pedidoPrato;
	}

}
