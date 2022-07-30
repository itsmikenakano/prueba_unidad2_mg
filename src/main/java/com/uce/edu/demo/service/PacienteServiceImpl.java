package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Override
	public void insertar(Paciente paciente) {
		this.iPacienteRepository.insertar(paciente);
		
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.iPacienteRepository.buscar(id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		return this.iPacienteRepository.buscarPorCedula(cedula);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.iPacienteRepository.actualizar(paciente);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.iPacienteRepository.eliminar(id);
		
	}

}
