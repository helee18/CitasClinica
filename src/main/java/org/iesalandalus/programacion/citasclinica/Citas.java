package org.iesalandalus.programacion.citasclinica;

public class Citas {
	private int capacidad, tamaño;

	public int getCapacidad() {
		return capacidad;
	}

	public int getTamaño() {
		return tamaño;
	}
	
	private boolean capacidadSuperada(int indice) {
		boolean superada = false;
		
		// comprobamos que el indice no supere la capacidad
		if (indice >= capacidad)
			superada = true;
		
		return superada;
	}
	
	private boolean tamañoSuperado(int indice) {
		boolean superado = false;
		
		// comprobamos que el indice no supere el tamaño
		if (indice >= tamaño)
			superado = true;
		
		return superado;
	}
}
