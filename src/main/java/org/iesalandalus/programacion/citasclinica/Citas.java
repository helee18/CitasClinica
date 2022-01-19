package org.iesalandalus.programacion.citasclinica;

public class Citas {
	private int capacidad, tamano;
	
	// Creamos un array con la coleccion de citas
	Cita[] coleccionCitas;

	public int getCapacidad() {
		return capacidad;
	}

	public int getTamano() {
		return tamano;
	}
	
	private boolean capacidadSuperada(int indice) {
		boolean superada = false;
		
		// comprobamos que el indice no supere la capacidad
		if (indice >= (capacidad-1))
			superada = true;
		
		return superada;
	}
	
	private boolean tamanoSuperado(int indice) {
		boolean superado = false;
		
		// comprobamos que el indice no supere el tamaño
		if (indice >= (tamano-1))
			superado = true;
		
		return superado;
	}
	
	private int buscarIndice (Cita cita) {
		int indice = -1;
		
		// consultamos en el array de citas la anterior	
		boolean citaPasada = false;
		do {
			indice++; // recorreremos uno a uno
			
			if (coleccionCitas[indice].equals(cita)) // en caso de que el objeto del array que estamos consultado sea la cita introducida
				citaPasada = true; 
			
		} while (!citaPasada && !tamanoSuperado(indice)); // salimos si encuentra la cida que hemos buscado o llegamos al ultimo objeto del array y no la encuentra
		
		return indice;
	}
	
	public Cita insertar (Cita cita) {
		if (cita == null) 
		{
			throw new NullPointerException("ERROR: No se puede insertar una cita nula.");
		}
				
		if (capacidadSuperada(indice))
			throw new OperationNotSupportedException("ERROR: No se aceptan más citas.");
		
		coleccionCitas[tamano-1] = new Cita(cita);
		tamano++;
		
		return coleccionCitas[tamano-1]	;	
	}
}
