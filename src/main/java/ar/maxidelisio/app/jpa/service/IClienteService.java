package ar.maxidelisio.app.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.maxidelisio.app.jpa.models.domain.Cliente;
import ar.maxidelisio.app.jpa.models.domain.Factura;
import ar.maxidelisio.app.jpa.models.domain.Producto;


public interface IClienteService {
	
	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable page);
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
	
	public List<Producto> findByName(String nameProd);
	
	public void saveFactura(Factura factura);
	
	public Producto findProductoById(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFacturaById(Long id);
}
