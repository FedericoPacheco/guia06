package died.guia06;

import org.junit.jupiter.api.Test;

import died.guia06.excepciones.CreditosInsuficientesException;
import died.guia06.excepciones.CupoCursoCubiertoException;
import died.guia06.excepciones.CupoDeInscripcionAlumnoAlcanzadoException;
import died.guia06.excepciones.RegistroAuditoriaException;

class AlumnoTest 
{
	Alumno a1, a2, a3;
	Curso c1, c2;
	
	public AlumnoTest()
	{
		a1 = new Alumno("Federico Pacheco", 26056);
		a2 = new Alumno("Camila Lerman", 27000);
		a3 = new Alumno("Sasha Schmunck", 270001);
		
		c1 = new Curso(1, "Señales y sistemas lineales", 2021, 2, 3, 0);
		c2 = new Curso(2, "Electrodinámica cuántica", 2021, 10, 5, 3);
	}
	
	@Test
	void testInscripcion1() 
	{
		System.out.println("");
		
		try 
		{
			System.out.println(a1.getNombre() + (c1.inscribirAlumno(a1)? " pudo ": " no pudo ") + "inscribirse al curso " + c1.getNombre());
			System.out.println(a2.getNombre() + (c1.inscribirAlumno(a2)? " pudo ": " no pudo ") + "inscribirse al curso " + c1.getNombre());
			System.out.println(a3.getNombre() + (c1.inscribirAlumno(a3)? " pudo ": " no pudo ") + "inscribirse al curso " + c1.getNombre());
		}
		catch 
		(
			CreditosInsuficientesException 			  | 
			CupoDeInscripcionAlumnoAlcanzadoException |
			CupoCursoCubiertoException				  |
			RegistroAuditoriaException e
		)
	    { System.out.println(e.getMessage()); }
		
		System.out.println("");
	}
	
	@Test
	void testInscripcion2() 
	{	
		System.out.println("");
		
		try
		{
			System.out.println(a1.getNombre() + (c2.inscribirAlumno(a1)? " pudo ": " no pudo ") + "inscribirse al curso " + c2.getNombre());
			System.out.println(a2.getNombre() + (c2.inscribirAlumno(a2)? " pudo ": " no pudo ") + "inscribirse al curso " + c2.getNombre());
			System.out.println(a3.getNombre() + (c2.inscribirAlumno(a3)? " pudo ": " no pudo ") + "inscribirse al curso " + c2.getNombre());
		}
		catch 
		(
			CreditosInsuficientesException 			  | 
			CupoDeInscripcionAlumnoAlcanzadoException |
			CupoCursoCubiertoException				  |
			RegistroAuditoriaException e
		)
	    { System.out.println(e.getMessage()); }
		
		System.out.println("");
	}
	
	@Test
	void testAprobar1() 
	{
		a1.aprobarCurso(c1);
		a2.aprobarCurso(c1);
		//a3.aprobarCurso(c1);
	}
	
	@Test
	void testAprobar2() 
	{
		a1.aprobarCurso(c2);
		a2.aprobarCurso(c2);
		//a3.aprobarCurso(c2);
	}
	
	@Test
	void testCreditosObtenidos() 
	{
		System.out.println("");
		System.out.println("Créditos de " + a1.getNombre() + ": " + a1.creditosObtenidos());
		System.out.println("Créditos de " + a2.getNombre() + ": " + a2.creditosObtenidos());
		System.out.println("Créditos de " + a3.getNombre() + ": " + a3.creditosObtenidos());
		System.out.println("");
	}
	
	@Test
	void imprimirInscriptos1() 
	{
		System.out.println("");
		System.out.println(c1.getNombre());
		
		System.out.println("Alfabéticamente: ");
		c1.imprimirInscriptosAlfabeticamente();
		
		System.out.println("Por número de libreta: ");
		c1.imprimirInscriptosPorLibretaUniversitaria();
	
		System.out.println("Por créditos obtenidos: ");
		c1.imprimirInscriptosPorCreditosObtenidos();
	
		System.out.println("");
	}
	
	@Test
	void imprimirInscriptos2() 
	{
		System.out.println("");
		System.out.println(c2.getNombre());
		
		System.out.println("Alfabéticamente: ");
		c2.imprimirInscriptosAlfabeticamente();
		
		System.out.println("Por número de libreta: ");
		c2.imprimirInscriptosPorLibretaUniversitaria();
	
		System.out.println("Por créditos obtenidos: ");
		c2.imprimirInscriptosPorCreditosObtenidos();
	
		System.out.println("");
	}
}
