package org.iesalandalus.programacion.citasclinica.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Paciente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private Consola () {
		
	}
	
	public static void mostrarMenu() {
		System.out.println("Menú");
		System.out.println("-----------------------------");
		System.out.println("1.- Insertar cita.");
		System.out.println("2.- Buscar cita.");
		System.out.println("3.- Borrar cita.");
		System.out.println("4.- Mostrar citas por día.");
		System.out.println("5.- Mostrar todas las citas.");
		System.out.println("0.- Salir.");
	}
	
	public static Opciones elegirOpcion() {
		// introducimos en un array las opciones
		Opciones[] opcion = Opciones.values();
		
		int opcionElegida;
		
		do {
			
			System.out.println("Seleccione una opción entre 0 y 5:");
			opcionElegida = Entrada.entero();
			
		} while (opcionElegida < 0 || opcionElegida > 5) ;

		return opcion[opcionElegida];
	}
	
	public static Paciente leerPaciente() throws OperationNotSupportedException {
		Paciente paciente;
		
		System.out.println("Introduzca el nombre:");
		String nombre = Entrada.cadena();
		
		System.out.println("Introduzca el teléfono:");
		String telefono = Entrada.cadena();
		
		System.out.println("Introduzca el DNI:");
		String dni = Entrada.cadena();
		
		paciente = new Paciente(nombre, dni, telefono);
		
		return paciente;
	}
	
}
