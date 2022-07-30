package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaSencilla {

	private String numero;

	private LocalDateTime fecha;

	private BigDecimal costo;

	private LocalDateTime fechaControl;

	public CitaSencilla() {

	}

	public CitaSencilla(String numero, LocalDateTime fecha, BigDecimal costo, LocalDateTime fechaControl) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.costo = costo;
		this.fechaControl = fechaControl;
	}

	@Override
	public String toString() {
		return "CitaSencilla [numero=" + numero + ", fecha=" + fecha + ", costo=" + costo + ", fechaControl="
				+ fechaControl + "]";
	}

	// SET Y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

}
