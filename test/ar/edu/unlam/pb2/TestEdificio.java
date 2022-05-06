package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestEdificio {

	@Test
	public void queSePuedaIngresarGenteAlEdificio() {
		Integer CANTIDAD_DE_PERSONAS_ESPERADAS = 1;
		Edificio samsung = new Edificio("Bouchard 451");
		Persona visitanteEsperado = new Persona(25465213, "Julio Lamas");
		
		samsung.ingresarPersona(visitanteEsperado);
		
		assertEquals((int)CANTIDAD_DE_PERSONAS_ESPERADAS, samsung.getPersonasEnElEdificio().size());
		assertTrue(samsung.getPersonasEnElEdificio().contains(visitanteEsperado));
	}
	
	@Test
	public void queNoSeDupliqueUnaMismaPersonaDentroDelEdificio() {
		// Preparación
		Integer CANTIDAD_DE_PERSONAS_ESPERADAS = 1;
		Edificio samsung = new Edificio("Bouchard 451");
		Persona visitanteEsperado = new Persona(25465213, "Julio Lamas");
		Persona visitanteDuplicado = new Persona(25465213, "Laura Fernandez");
		
		// Ejecución
		samsung.ingresarPersona(visitanteEsperado);
		samsung.ingresarPersona(visitanteDuplicado);
		
		// Validación
		assertEquals((int)CANTIDAD_DE_PERSONAS_ESPERADAS, samsung.getPersonasEnElEdificio().size());
		assertTrue(samsung.getPersonasEnElEdificio().contains(visitanteEsperado));
	}
	
	@Test
	public void queSePuedanIdentificarLosEmpleadosQueEstanActualmenteEnElEdificio() {
		// Preparación
		Integer CANTIDAD_DE_EMPLEADOS_ESPERADOS = 2;
		Edificio samsung = new Edificio("Bouchard 451");
		Persona visitanteEsperado = new Persona(25465213, "Julio Lamas");
		Persona visitanteDuplicado = new Persona(25465213, "Laura Fernandez");
		Empleado puntual = new Empleado(10, "Lionel Messi", "PSG");
		Empleado imputual = new Empleado(2, "Malena Guinzburg", "Telefe");
		
		// Ejecución
		samsung.ingresarPersona(visitanteEsperado);
		samsung.ingresarPersona(visitanteDuplicado);
		samsung.ingresarPersona(puntual);
		samsung.ingresarPersona(imputual);
		
		// Validación
		assertEquals((int)CANTIDAD_DE_EMPLEADOS_ESPERADOS, samsung.getEmpleadosEnElEdificio().size());
		assertEquals(samsung.getEmpleadosEnElEdificio().first(), imputual);
		
		
	}
	
	@Test
	public void queNoSePuedanIngresarEmpleadosDuplicados() {
		// Preparación
		Integer CANTIDAD_DE_EMPLEADOS_ESPERADOS = 2;
		Edificio samsung = new Edificio("Bouchard 451");
		Empleado puntual = new Empleado(9, "Mauro Icardi", "PSG");
		Empleado imputual = new Empleado(1, "Wanda Nara", "Telefe");
		Empleado tercera = new Empleado(1, "China Suarez", "Telefe");
		
		// Ejecución
		samsung.ingresarPersona(puntual);
		samsung.ingresarPersona(imputual);
		
		TreeSet<Empleado> empleadosActuales = samsung.getEmpleadosEnElEdificio();
		empleadosActuales.add(tercera);
		
		// Validación
		assertEquals((int)CANTIDAD_DE_EMPLEADOS_ESPERADOS, samsung.getEmpleadosEnElEdificio().size());
		assertEquals(samsung.getEmpleadosEnElEdificio().first(), imputual);
		
		
	}

}
