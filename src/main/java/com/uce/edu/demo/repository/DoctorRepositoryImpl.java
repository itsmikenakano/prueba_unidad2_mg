package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		this.entityManager.persist(doctor);
		
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		TypedQuery<Doctor> myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula= :datoCedula", Doctor.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.entityManager.merge(doctor);
		
	}

	@Override
	public void eliminar(Integer id) {
		Doctor doctor = this.buscar(id);
		this.entityManager.remove(doctor);
		
	}

}
