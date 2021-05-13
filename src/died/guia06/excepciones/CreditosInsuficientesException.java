package died.guia06.excepciones;

import died.guia06.Alumno;
import died.guia06.Curso;

@SuppressWarnings("serial")
public class CreditosInsuficientesException extends Exception 
{
	public CreditosInsuficientesException(Alumno alumno, Curso curso)
	{
		super("Error. El alumno " + alumno.getNombre() + " no tiene suficientes créditos para inscribirse a " + curso.getNombre());
	}
}
