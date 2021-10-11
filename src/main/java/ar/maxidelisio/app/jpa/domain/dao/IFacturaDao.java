package ar.maxidelisio.app.jpa.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.maxidelisio.app.jpa.models.domain.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
