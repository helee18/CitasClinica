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
	
	public Paciente getPaciente() {
		
		return paciente;
	}

	private void setPaciente(Paciente paciente) {
		if (paciente == null) {
			throw new NullPointerException("ERROR: El paciente de una cita no puede ser nulo.");
		}
		
		this.paciente = new Paciente(paciente);
	}
	
}
