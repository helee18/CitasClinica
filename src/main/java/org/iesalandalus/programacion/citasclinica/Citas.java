package org.iesalandalus.programacion.citasclinica;

import javax.naming.OperationNotSupportedException;

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
		
		// consultamos en el array de citas si la encuentra
		boolean citaEncontrada = false;
		do {
			indice++; // recorreremos uno a uno
			
			if (coleccionCitas[indice].equals(cita)) // en caso de que el objeto del array que estamos consultado sea la cita introducida
				citaEncontrada = true; 
			
		} while (!citaEncontrada && !tamanoSuperado(indice)); // salimos si encuentra la cida que hemos buscado o llegamos al ultimo objeto del array y no la encuentra
		
		if (!citaEncontrada)
			indice = tamano++;
		
		return indice;
	}
	
	public void insertar (Cita cita) throws OperationNotSupportedException {
		if (cita == null) 
		{
			throw new NullPointerException("ERROR: No se puede insertar una cita nula.");
		}
		
		int indice = buscarIndice(cita);
		
		if (capacidadSuperada(indice))
			throw new OperationNotSupportedException("ERROR: No se aceptan más citas.");
		
		// si el indice supera al tamaño, es que no lo ha encontrado y es un objeto nuevo
		if (!tamanoSuperado(indice))
			throw new OperationNotSupportedException("ERROR: Ya existe una cita para esa fecha y hora.");
		
		// insertamos la nueva cita y actualizamos el tamaño
		coleccionCitas[indice] = new Cita(cita);
		tamano++;
	}
	
	public Cita buscar (Cita cita) {
		int indice = buscarIndice(cita);
		
		// si el indice supera al tamaño, es que no lo ha encontrado y es un objeto nuevo
		if (!tamanoSuperado(indice))
			return new Cita(cita);
		else
			return null;
	}
}
