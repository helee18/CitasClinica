package org.iesalandalus.programacion.citasclinica;

public class Paciente {
	private static final String ER_DNI="12345678Z", ER_TELEFONO="123456789";
	private String nombre, dni, telefono;
	
	private String formateaNombre (String nombre) {
		
		// Borrar espacios, tabulaciones y retornos al principio y al final
		nombre = nombre.replaceAll("^\\s*","");
		nombre = nombre.replaceAll("\\s*$","");
		
		// Borrar espacios de sobra en medio
		nombre = nombre.replaceAll("\\s{2,}"," ");
		
		// Mayusculas y minusculas
		String nombreNuevo = "";
		String[] palabras = nombre.split(" "); // Separar nombre por palabras
		
		for (int i=0; i<=palabras.length-1; i++) { // Recorrer cada palabra
			palabras[i] = palabras[i].substring(0,1).toUpperCase() + palabras[i].substring(1).toLowerCase(); // Poner primera letra en mayuscula y resto en minuscula
			nombreNuevo = nombreNuevo + " " + palabras[i]; // Juntamos cada palabra separadas por un espacio
		}
		
		return nombre;
	}
}
