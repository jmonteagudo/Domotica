package ar.edu.unlam.pb2;

public class Empleado extends Persona implements Comparable{
	
	private String empresa;

	public Empleado(Integer dni, String nombre, String empresa) {
		super(dni, nombre);
		this.empresa = empresa;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Empleado elementoAComparar = (Empleado)o;
		return (this.getDni()-elementoAComparar.getDni());
	}

}
