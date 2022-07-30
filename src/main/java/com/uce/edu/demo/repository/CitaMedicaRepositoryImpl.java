package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaSencilla;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica cita) {
		this.entityManager.persist(cita);

	}

	@Override
	public void actualizar(CitaMedica cita) {
		this.entityManager.merge(cita);

	}

	@Override
	public CitaMedica buscarPorNumero(String numeroCita) {
		TypedQuery<CitaMedica> myQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numero= :datoNumero", CitaMedica.class);
		myQuery.setParameter("datoNumero", numeroCita);

		return myQuery.getSingleResult();
	}

	@Override
	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fechaCita, BigDecimal costoCita) {
		TypedQuery<CitaSencilla> myQuery = this.entityManager.createQuery(
				"SELECT new com.uce.edu.demo.repository.modelo.CitaSencilla(c.numero, c.fecha, c.costo, c.fechaControl) FROM CitaMedica c WHERE c.fecha> :datoFecha AND c.costo> :datoCosto",
				CitaSencilla.class);
		myQuery.setParameter("datoFecha", fechaCita);
		myQuery.setParameter("datoCosto", costoCita);
		return myQuery.getResultList();
	}

}
