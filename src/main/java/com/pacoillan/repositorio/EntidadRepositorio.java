package com.pacoillan.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pacoillan.objetos.Entidad;

@Repository
public class EntidadRepositorio {

	@PersistenceContext
	private EntityManager em;
	


	public List<Entidad> buscarTodas() {
		TypedQuery<Entidad> consultaJPA = em.createQuery("select e from Entidad e", Entidad.class);
		return consultaJPA.getResultList();
	}

	
	public List<Entidad> listadoConfigurable(String query){
		TypedQuery<Entidad> consultaJPA = em.createQuery(query,Entidad.class);
		return consultaJPA.getResultList();
	}
	
	@Transactional
	public void insertar(Entidad entidad) {
		em.persist(entidad);
	}

	@Transactional
	public void borrar(Entidad entidad) {
		em.remove(em.merge(entidad));
	}

	public Entidad consultarId(int id) {
		Entidad entidad = em.find(Entidad.class, id);
		return entidad;
	}

}
