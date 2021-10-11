package ar.maxidelisio.app.jpa.models.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String descripcion;
	private String observacion;
	
	@Temporal(TemporalType.DATE)	
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.EAGER)	
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "factura_id")
	private List<ItemFactura> itemsFactura;
	
	public Factura() {
		
		itemsFactura = new ArrayList<>();
		
	}
	
	@PrePersist
	private void prePersist() {
		fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public List<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemsFactura(List<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	

	public void addItemFactura(ItemFactura item) {
		this.itemsFactura.add(item);
	}
	
	public Double getTotal() {
		
		Double total = 0.0;
		int size = itemsFactura.size();
		
		for(int i=0 ; i < size ; i++) {
			total += itemsFactura.get(i).calcularImporte();
		}
		
		return total;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
