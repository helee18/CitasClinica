package org.iesalandalus.programacion.citasclinica;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.modelo.Paciente;
import org.iesalandalus.programacion.citasclinica.vista.Consola;
import org.iesalandalus.programacion.citasclinica.vista.Opciones;

public class MainApp {
	
	public static final int NUM_MAX_CITAS = 10;
	static Citas citas = new Citas(NUM_MAX_CITAS);

	public static void main(String[] args) {
		Opciones opcion;
		
		do {
			System.out.println("Programa para gestionar las citas de la Clínica.");
			Consola.mostrarMenu();
			
			opcion = Consola.elegirOpcion();
			ejecutarOpcion(opcion);
			
		} while (opcion != Opciones.SALIR);
	} 
	
	public static void ejecutarOpcion (Opciones opcion) {
		switch (opcion) {
		case INSERTAR_CITA:
			insertarCita();
			break;
		case BUSCAR_CITA:
			buscarCita();
			break;
		case BORRAR_CITA:
			borrarCita();
			break;
		case MOSTRAR_CITAS_DIA:
			mostrarCitasDia();
			break;
		case MOSTRAR_CITAS:
			mostrarCitas();
			break;
		case SALIR:
			System.out.println("");
			System.out.print("¡Sesión terminada!");
			break;
		}
	}
	
	private static void insertarCita () {
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
	
	private static void buscarCita () {
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
	
	private static void borrarCita() {
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
	
	private static void mostrarCitas () {
		try {
			Cita[] citasMostrar = citas.getCitas();
			
			System.out.println(citasMostrar);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void mostrarCitasDia () {
		try {
			LocalDate fecha = Consola.leerFecha();
			Cita[] citasMostrar = citas.getCitas(fecha);
			
			System.out.println(citasMostrar);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
