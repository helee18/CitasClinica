package org.iesalandalus.programacion.citasclinica.vista;

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
		System.out.println("6.- Salir.");
	}
}
