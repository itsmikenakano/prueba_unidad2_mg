package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaSencilla;

public interface IGestorCitaService {

	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);

	public void actualizarPorNumeroCita(String numeroCita, String Diagnostico, String receta,
			LocalDateTime fechaProximaCita);

	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo);

}
