package ar.maxidelisio.app.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.maxidelisio.app.jpa.domain.dao.IClienteDao;
import ar.maxidelisio.app.jpa.domain.dao.IFacturaDao;
import ar.maxidelisio.app.jpa.domain.dao.IProductoDao;
import ar.maxidelisio.app.jpa.models.domain.Cliente;
import ar.maxidelisio.app.jpa.models.domain.Factura;
import ar.maxidelisio.app.jpa.models.domain.Producto;

@Transactional
@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	public List<Cliente> findAll() {		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	public Page<Cliente> findAll(Pageable page) {		
		return clienteDao.findAll(page);
	}

	@Override
	public List<Producto> findByName(String nameProd) {		
		return productoDao.findByName(nameProd);
	}

	@Override
	public void saveFactura(Factura factura) {		
		facturaDao.save(factura);
	}

	@Override
	public Producto findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public Factura findFacturaById(Long id) {		
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
		
	}

}
