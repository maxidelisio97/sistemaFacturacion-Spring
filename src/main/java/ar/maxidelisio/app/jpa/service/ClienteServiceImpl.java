package ar.maxidelisio.app.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.maxidelisio.app.jpa.domain.dao.IClienteDao;
import ar.maxidelisio.app.jpa.models.domain.Cliente;

@Transactional
@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	public List<Cliente> getClientes() {		
		return clienteDao.getClientes();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		clienteDao.delete(id);
	}

}
