package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaSencilla;

public interface ICitaMedicaRepository {
	
	public void insertar(CitaMedica cita);
	
	public void actualizar(CitaMedica cita);
	
	public CitaMedica buscarPorNumero(String numeroCita);
	
	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fechaCita, BigDecimal costoCita);
}
