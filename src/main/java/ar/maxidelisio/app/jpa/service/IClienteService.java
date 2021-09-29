package ar.maxidelisio.app.jpa.service;

import java.util.List;


import ar.maxidelisio.app.jpa.models.domain.Cliente;


public interface IClienteService {
	
	public List<Cliente> getClientes();

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
