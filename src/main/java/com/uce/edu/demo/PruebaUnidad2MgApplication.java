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
		doctor.setTitulo("Medicina General");
		doctor.setSalario("1200.00 $");

		this.iDoctorService.insertar(doctor);

		Doctor doctor1 = new Doctor();
		doctor1.setCedula("1234");
		doctor1.setNombre("Milena");
		doctor1.setApellido("Sandoval");
		doctor1.setFechaNacimiento(LocalDateTime.now());
		doctor1.setNumeroConsultorio("28");
		doctor1.setTitulo("Medicina General");
		doctor1.setSalario("1500.00 $");

		this.iDoctorService.insertar(doctor1);

		Paciente paciente = new Paciente();
		paciente.setCedula("987");
		paciente.setNombre("Luis");
		paciente.setApellido("Suarez");
		paciente.setFechaNacimiento(LocalDateTime.now());
		paciente.setCodigoIess("KJ90");
		paciente.setEstatura("1.70");
		paciente.setPeso("58 kg");
		paciente.setGenero("Masculino");

		this.iPacienteService.insertar(paciente);

		Paciente paciente1 = new Paciente();
		paciente1.setCedula("532");
		paciente1.setNombre("Maria");
		paciente1.setApellido("Rodriguez");
		paciente1.setFechaNacimiento(LocalDateTime.now());
		paciente1.setCodigoIess("P90");
		paciente1.setEstatura("1.60");
		paciente1.setPeso("51 kg");
		paciente1.setGenero("Femenino");

		this.iPacienteService.insertar(paciente1);
		
		//3. Funcionalidad agendamiento cita medica
		this.iGestorCitaService.agendar("1", LocalDateTime.now(), new BigDecimal(100), "Hospital Santa Anita", doctor.getCedula(),paciente.getCedula());
		this.iGestorCitaService.agendar("2", LocalDateTime.now(), new BigDecimal(150), "Hospital Santa Anita", doctor1.getCedula(), paciente.getCedula());
		this.iGestorCitaService.agendar("3", LocalDateTime.now(), new BigDecimal(90), "Hospital Santa Anita", doctor1.getCedula(), paciente1.getCedula());

		// 4. Funcionalidad actualización cita medica
		this.iGestorCitaService.actualizarPorNumeroCita("1", "Gripe", "Paracetamol y Bisolvon", LocalDateTime.now());

		// 5. Funcionalidad reporte de citas medicas
		List<CitaSencilla> citas = this.iGestorCitaService.buscarPorFechaCosto(LocalDateTime.of(2022, 7, 28, 7, 55),
				new BigDecimal(98));
		
		LOG.info("Reporte Citas Sencillas");
		for (CitaSencilla citaSencilla : citas) {
			LOG.info("Citas Sencilla: " +citaSencilla);
		}

	}

}
