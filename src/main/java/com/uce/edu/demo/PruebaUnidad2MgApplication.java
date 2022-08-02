package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.CitaSencilla;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(PruebaUnidad2MgApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2MgApplication.class, args);
	}

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private IDoctorService iDoctorService;

	@Autowired
	private IGestorCitaService iGestorCitaService;

	@Override
	public void run(String... args) throws Exception {
		Doctor doctor = new Doctor();
		doctor.setCedula("2300290992");
		doctor.setNombre("Michael");
		doctor.setApellido("Garcia");
		doctor.setFechaNacimiento(LocalDateTime.now());
		doctor.setNumeroConsultorio("15");
		doctor.setCodigoSenescyt("2154125");
		doctor.setGenero("Masculino");

		//this.iDoctorService.insertar(doctor);

		Doctor doctor1 = new Doctor();
		doctor1.setCedula("1234");
		doctor1.setNombre("Milena");
		doctor1.setApellido("Sandoval");
		doctor1.setFechaNacimiento(LocalDateTime.now());
		doctor1.setNumeroConsultorio("28");
		doctor.setCodigoSenescyt("12512");
		doctor.setGenero("Femenino");

		//this.iDoctorService.insertar(doctor1);

		Paciente paciente = new Paciente();
		paciente.setCedula("987");
		paciente.setNombre("Luis");
		paciente.setApellido("Suarez");
		paciente.setFechaNacimiento(LocalDateTime.of(1990, 12, 2, 8, 56));
		paciente.setCodigoSeguro("KJ90");
		paciente.setEstatura(new Double(170));
		paciente.setPeso(new Double(58));
		paciente.setGenero("Masculino");

		//this.iPacienteService.insertar(paciente);

		Paciente paciente1 = new Paciente();
		paciente1.setCedula("532");
		paciente1.setNombre("Maria");
		paciente1.setApellido("Rodriguez");
		paciente1.setFechaNacimiento(LocalDateTime.of(1996, 12, 2, 8, 56));
		paciente1.setCodigoSeguro("P90");
		paciente1.setEstatura(new Double(160));
		paciente1.setPeso(new Double(51));
		paciente1.setGenero("Femenino");

		//this.iPacienteService.insertar(paciente1);

		// 3. Funcionalidad agendamiento cita medica
		//this.iGestorCitaService.agendar("1", LocalDateTime.now(), new BigDecimal(100), "Hospital Santa Anita",
		//		"2300290992", "987");

		// 4. Funcionalidad actualización cita medica
		//this.iGestorCitaService.actualizarPorNumeroCita("1", "Gripe", "Paracetamol y Bisolvon", LocalDateTime.now());
		
		//5. Funcionalidad informe pacientes
		List<PacienteSencillo> lista = this.iGestorCitaService
				.buscarPorFechaGenero(LocalDateTime.of(1992, 12, 2, 8, 56), "Femenino");

		for (PacienteSencillo pacienteSencillo : lista) {
			LOG.info("Paciente Sencillo: " + pacienteSencillo);
		}

	}

}
