package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

public class Citas {
	private int capacidad, tamano;
	
	// Declaramos un array con la coleccion de citas
	Cita[] coleccionCitas;
	
	// constructor
	public Citas (int capacidadColeccionCitas) {
		if (capacidadColeccionCitas <= 0)
			throw new NullPointerException("ERROR: La capacidad debe ser mayor que cero.");
		
		// Creamos el array con la capacidad introducida
		coleccionCitas = new Cita[capacidadColeccionCitas];
		
		// Actualizamos los atributos capacidad y tamaño
		capacidad = capacidadColeccionCitas;
		tamano = 0;
	}
	
	public Cita[] getCitas() {
		return coleccionCitas;
	}
	
	public Cita[] getCitas (LocalDate fecha) {
		if (fecha==null)
			throw new NullPointerException("ERROR: No se pueden devolver las citas para un día nulo.");
		
		// creamos un array para las citas que encontremos en la fecha introducida
		Cita[] citasFecha = new Cita[tamano];
		int indice = -1;
		
		// recorremos todas las citas comparando
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionCitas[i].getFechaHora().toLocalDate().equals(fecha)) // si ponemos == no se compararia bien
				citasFecha[indice++] = coleccionCitas[i];
		}
		
		return citasFecha;
	}
 
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
	
	private void desplazarUnaPosicionHaciaIzquierda (int indice) {
		for (int i = indice; !tamanoSuperado(i); i++) { // recorrer todos los objetos hacia la derecha a partir del indice hasta legar al final
			coleccionCitas[i] = coleccionCitas[i+1]; // asignamos en cada posicion el objeto siguiente
		}
	}
	
	public void borrar (Cita cita) throws OperationNotSupportedException {
		if (cita == null) 
		{
			throw new NullPointerException("ERROR: No se puede insertar una cita nula.");
		}
		
		// si no encuentra la cita salta error
		if (buscar(cita) == null)
			throw new OperationNotSupportedException("ERROR: No existe ninguna cita para esa fecha y hora.");
		
		// borrar cita
		int indice = buscarIndice(cita); // buscamos indice de cita a borrar
		
		coleccionCitas[indice] = null; // asignamos un elemento vacio en esa posicion
		
		desplazarUnaPosicionHaciaIzquierda(indice); // movemos todo para no dejar huecos en medio
		
		// actualizamos tamaño
		tamano--;
	}
}
