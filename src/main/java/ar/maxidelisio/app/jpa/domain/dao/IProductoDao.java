package ar.maxidelisio.app.jpa.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.maxidelisio.app.jpa.models.domain.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.descripcion like %?1%")
	public List<Producto> findByName(String nameProd);
	
	//public List<Producto> findByNameLikeIgnoreCase(String nameProd);

}
