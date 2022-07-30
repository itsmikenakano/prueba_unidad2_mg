package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaSencilla;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{
	
	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;

	@Override
	public void insertar(CitaMedica cita) {
		this.iCitaMedicaRepository.insertar(cita);
		
	}

	@Override
	public void actualizar(CitaMedica cita) {
		this.iCitaMedicaRepository.actualizar(cita);
	}

	@Override
	public CitaMedica buscarPorNumero(String numeroCita) {
		return this.iCitaMedicaRepository.buscarPorNumero(numeroCita);
	}

	@Override
	public List<CitaSencilla> buscarPorFechaCosto(LocalDateTime fechaCita, BigDecimal costoCita) {
		return this.iCitaMedicaRepository.buscarPorFechaCosto(fechaCita, costoCita);
	}

}
