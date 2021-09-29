package ar.maxidelisio.app.jpa.domain.dao;

import java.util.List;

import ar.maxidelisio.app.jpa.models.domain.Cliente;

public interface IClienteDao {
	
	public List<Cliente> getClientes();

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

}
