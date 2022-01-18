package org.iesalandalus.programacion.citasclinica;

import java.time.LocalDateTime;

public class Cita {
	public static final String FORMATO_FECHA_HORA="dd/MM/yyyy HH:mm";
	private LocalDateTime fechaHora;
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(LocalDateTime fechaHora) {
		if (fechaHora == null)
			throw new NullPointerException("ERROR: La fecha es nula.");
		
		this.fechaHora = fechaHora;
	}
	
	
}
