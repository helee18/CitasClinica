package org.iesalandalus.programacion.citasclinica.vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
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
			
			System.out.println("Seleccione una opción entre 0-5 ");
			opcionElegida = Entrada.entero();
			
		} while (opcionElegida < 0 || opcionElegida > 5) ;

		return opcion[opcionElegida];
	}
	
	public static Paciente leerPaciente() throws OperationNotSupportedException {
		Paciente paciente;
		
		System.out.println("Introduzca el nombre ");
		String nombre = Entrada.cadena();
		
		System.out.println("Introduzca el teléfono ");
		String telefono = Entrada.cadena();
		
		System.out.println("Introduzca el DNI:");
		String dni = Entrada.cadena();
		
		paciente = new Paciente(nombre, dni, telefono);
		
		return paciente;
	}
	
	public static LocalDateTime leerFechaHora() 
	{
		// definimos el patron que debe seguir la fechahora
		String patron = "dd/MM/yyyy HH:mm";
		LocalDateTime fechaHora = null;
		
		boolean fechaValida = false;
		do 
		{
			try // probamos a pedir la fecha hora y solo si no salta error seguimos sin repetir la pregunta
			{
				System.out.println("Introduzca una fecha y hora con el formato dd/MM/aaaa HH:mm ");
				fechaHora = LocalDateTime.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(patron));
				
				fechaValida = true;
				
			} catch (DateTimeParseException e) {
				fechaValida = false;
			}
			
		} while (!fechaValida);
		
		return fechaHora;
	}
	
	public static Cita leerCita() throws OperationNotSupportedException {
		Cita cita = new Cita(leerPaciente(), leerFechaHora());
		
		return cita;
	}
	
	public static LocalDate leerFecha() {
		String formatoCadena = "dd/MM/yyyy";
		LocalDate fecha = null;
		boolean fechaValida = false;
		
		do
		{
			try 
			{
				System.out.println("Introduzca una fecha con el formato dd/MM/aaaa ");
				fecha = LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(formatoCadena));
				fechaValida = true;
				
			} catch (DateTimeParseException e) {
				fechaValida = false;
			}
		} while (!fechaValida);
		
		return fecha;
	}
}
