package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);

	}

	@Override
	public Paciente buscar(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		TypedQuery<Paciente> myQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula= :datoCedula", Paciente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);

	}

	@Override
	public void eliminar(Integer id) {
		Paciente paciente = this.buscar(id);
		this.entityManager.remove(paciente);

	}

}
