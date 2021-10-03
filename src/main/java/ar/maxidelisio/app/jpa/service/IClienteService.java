package ar.maxidelisio.app.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.maxidelisio.app.jpa.models.domain.Cliente;


public interface IClienteService {
	
	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable page);
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
