package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.TreeSet;

public class Edificio {

	private String direccion;
	private HashSet<Persona> actualmenteEnElEdificio;
	
	public Edificio(String direccion) {
		this.direccion = direccion;
		this.actualmenteEnElEdificio = new HashSet<Persona>();
	}

	public String toString() {
		return direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edificio other = (Edificio) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}

	public void ingresarPersona(Persona nueva) {
		actualmenteEnElEdificio.add(nueva);
	}

	public HashSet<Persona> getPersonasEnElEdificio() {
		return actualmenteEnElEdificio;
	}

	public TreeSet<Empleado> getEmpleadosEnElEdificio() {
		TreeSet<Empleado> empleadosEnElEdifio = new TreeSet<Empleado>();
		for(Persona actual: actualmenteEnElEdificio) {
			if(actual instanceof Empleado) {
				empleadosEnElEdifio.add((Empleado)actual);
			}
		}
		return empleadosEnElEdifio;
	}
	
	
}
