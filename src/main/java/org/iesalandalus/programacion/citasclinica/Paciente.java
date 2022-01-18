package org.iesalandalus.programacion.citasclinica;

import java.util.Objects;

public class Paciente {
	private static final String ER_DNI="([0-9]{8})([A-Z])", ER_TELEFONO="[69][0-9]{8}";
	private String nombre, dni, telefono;
	
	public Paciente (String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}
	
	public Paciente (Paciente pacienteOrigen) {
		if (pacienteOrigen==null)
			throw new NullPointerException("ERROR: No es posible copiar un paciente nulo.");
		
		setNombre(pacienteOrigen.getNombre());
		setDni(pacienteOrigen.getDni());
		setTelefono(pacienteOrigen.getTelefono());
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new NullPointerException ("ERROR: El nombre de un paciente no puede ser nulo o vacío.");
		
		this.nombre = formateaNombre(nombre);
	}
	
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
	
	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null)
			throw new NullPointerException("ERROR: El DNI de un paciente no puede ser nulo o vacío.");
		if (dni.compareTo(ER_DNI) != 0 || comprobarLetraDni(dni) == false)
			throw new IllegalArgumentException("ERROR_DNI_NO_VALIDO");
		
		this.dni = dni;
	} 
	
	private boolean comprobarLetraDni (String dni) {
		
		boolean letraValida = false; // Solo cambiará a true si es valida
		
		String[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"}; // Array con el orden de las letras concreto
		
		String letraDni = dni.substring(8,9); // Sacamos la letra del DNI introducido
		
		int numeroDni = Integer.parseInt(dni.substring(0,8)); // Sacamos los numeros del DNI introducido
		
		int resto = numeroDni % 23; // Calculamos el resto del numero del DNI introducido
		
		if (letraDni.compareTo(letras[resto]) == 0)
				letraValida = true;
		
		return letraValida;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null)
			throw new NullPointerException("ERROR: El teléfono de un paciente no puede ser nulo o vacío.");
		if (telefono.compareTo(ER_TELEFONO) != 0)
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		
		this.telefono = telefono;
	}
	
	private String getIniciales () {
		String iniciales = "";
		
		String[] palabras = nombre.split(" "); // Separar nombre por palabras

		for (int i=0; i<=palabras.length-1; i++) { // Recorrer cada palabra
			iniciales = iniciales + palabras[i].substring(0,1); // Juntamos las iniciales
		}
		
		return iniciales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		
		// Comparamos el dni para saber si los objetos son iguales
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Paciente [(" + getIniciales() + ")" + "nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + "]";
	}
	
	
	
}
