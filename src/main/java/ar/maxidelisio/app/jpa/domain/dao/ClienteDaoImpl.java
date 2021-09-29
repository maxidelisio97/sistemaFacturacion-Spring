package ar.maxidelisio.app.jpa.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ar.maxidelisio.app.jpa.models.domain.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override	
	public List<Cliente> getClientes() {

		return em.createQuery("from Cliente").getResultList();

	}

	@Override	
	public void save(Cliente cliente) {

		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	@Override	
	public Cliente findOne(Long id) {

		return em.find(Cliente.class, id);
	}

	@Override	
	public void delete(Long id) {
		
		em.remove(findOne(id));
		
	}

}
