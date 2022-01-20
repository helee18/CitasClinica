package org.iesalandalus.programacion.citasclinica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.modelo.Paciente;
import org.iesalandalus.programacion.citasclinica.vista.Consola;

public class MainApp {
	
	public static final int NUM_MAX_CITAS = 10;
	Citas citas = new Citas(NUM_MAX_CITAS); ///////////////////CONSTRUCTOR//

	public static void main(String[] args) {
		int opcion=0;
		
		do {
			System.out.println("Programa para gestionar las citas de la Clínica.");
			Consola.mostrarMenu();
			
			//opcion = elegirOpcion();
			//ejecutarOpcion(opcion);
			
		} while (opcion >= 0 && opcion >= 5);
	}
	
	private void insertarCita () {
		try {
			// creamos una cita
			Cita cita = Consola.leerCita();
			
			// añadimos la cita al array de citas
			citas.insertar(cita);
			
			System.out.println(" Cita asignada ");
			
		} catch (IllegalArgumentException | OperationNotSupportedException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void buscarCita () {
		try {
			
			LocalDateTime fechaHora = Consola.leerFechaHora(); // pedimos fecha
			Paciente paciente = new Paciente("x", "12345678Z", "677777777"); // creamos un paciente cualquiera
			Cita cita = new Cita (paciente, fechaHora); // creamos una cita
			
			// buscamos la cita
			Cita citaBuscada = citas.buscar(cita);
			
			if (citaBuscada == null)
				System.out.println(" No existe la cita ");
			else 
				System.out.println(citaBuscada);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void borrarCita() {
		try {
			LocalDateTime fechaHora = Consola.leerFechaHora(); // pedimos fecha
			Paciente paciente = new Paciente("x", "12345678Z", "677777777"); // creamos un paciente cualquiera
			Cita cita = new Cita (paciente, fechaHora); // creamos una cita
			
			// buscamos la cita
			citas.borrar(cita);
			
			System.out.println(" Se ha borrado la cita ");
			
		} catch (IllegalArgumentException | OperationNotSupportedException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void mostrarCitas () {
		try {
			Cita[] citasMostrar = citas.getCitas();
			
			System.out.println(citasMostrar);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void mostrarCitasFecha () {
		try {
			LocalDate fecha = Consola.leerFecha();
			Cita[] citasMostrar = citas.getCitas(fecha);
			
			System.out.println(citasMostrar);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
