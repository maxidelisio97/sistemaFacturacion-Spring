package ar.maxidelisio.app.jpa.domain.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import ar.maxidelisio.app.jpa.models.domain.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente,Long>{
	

}
