package ar.maxidelisio.app.jpa.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.maxidelisio.app.jpa.models.domain.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{
	

}
