package org.iesalandalus.programacion.citasclinica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Citas;
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
			// pedimos al fecha y hora
			LocalDateTime fechaHora = Consola.leerFechaHora();
			// lo convertimos en fecha (asi lo pide el metodo getcitas
			LocalDate fecha = fechaHora.toLocalDate();
			// buscamos las citas en esa fecha
			Cita[] cita = citas.getCitas(fecha);
			
			System.out.println(cita);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
