package org.iesalandalus.programacion.citasclinica;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.vista.Consola;

public class MainApp {
	
	public static final int NUM_MAX_CITAS = 10;
	private static Citas listaCitas = new Citas(NUM_MAX_CITAS);

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
			
			// la añadimos al array de citas
			Citas citas = new Citas(NUM_MAX_CITAS);
			citas.insertar(cita);
			
			System.out.println(" Cita asignada correctamente.");
			
		} catch (IllegalArgumentException | OperationNotSupportedException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
