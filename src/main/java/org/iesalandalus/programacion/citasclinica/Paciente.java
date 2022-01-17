package org.iesalandalus.programacion.citasclinica;

public class Paciente {
	private static final String ER_DNI="([0-9]{8})([A-Za-z])", ER_TELEFONO="123456789";
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
		
		return nombreNuevo;
	}
	
	private boolean comprobarLetraDni (String dni) {
		
		boolean letraValida = false; // Solo cambiará a true si es valida
		
		String[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"}; // Array con el orden de las letras concreto
		
		String letraDNI = dni.substring(8,9); // Sacamos la letra del DNI introducido
		
		int numeroDNI = Integer.parseInt(dni.substring(0,8)); // Sacamos los numeros del DNI introducido
		
		int resto = numeroDNI % 23; // Calculamos el resto del numero del DNI introducido
		
		if (letraDNI.compareTo(letras[resto]) == 0)
				letraValida = true;
		
		return letraValida;
	}
}
