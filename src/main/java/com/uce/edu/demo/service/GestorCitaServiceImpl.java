package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaSencilla;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService {

	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {

		CitaMedica cita = new CitaMedica();
		cita.setNumero(numeroCita);
		cita.setFecha(fechaCita);
		cita.setValor(valorCita);
		cita.setLugar(lugarCita);

		Doctor d = this.iDoctorRepository.buscarPorCedula(cedulaDoctor);
		cita.setDoctor(d);

		Paciente p = this.iPacienteRepository.buscarPorCedula(cedulaPaciente);
		cita.setPaciente(p);

		this.iCitaMedicaRepository.insertar(cita);

	}

	@Override
	public void actualizarPorNumeroCita(String numeroCita, String diagnostico, String receta,
			LocalDateTime fechaControl) {
		CitaMedica cita = this.iCitaMedicaRepository.buscarPorNumero(numeroCita);
		cita.setDiagnostico(diagnostico);
		cita.setReceta(receta);
		cita.setFechaProximaCita(fechaControl);

		this.iCitaMedicaRepository.actualizar(cita);

	}

	@Override
	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo) {

		return this.iCitaMedicaRepository.buscarPorFechaCosto(fecha, costo);
	}

	@Override
	public List<PacienteSencillo> buscarPorFechaGenero(LocalDateTime fecha, String genero) {

		return this.iPacienteRepository.buscarPorFechaGenero(fecha, genero);
	}

}
