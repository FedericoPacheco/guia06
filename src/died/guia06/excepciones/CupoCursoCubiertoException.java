package died.guia06.excepciones;

import died.guia06.Curso;

@SuppressWarnings("serial")
public class CupoCursoCubiertoException extends Exception 
{
	public CupoCursoCubiertoException(Curso curso)
	{
		super("Error. El cupo del curso " + curso.getNombre() + " ya ha sido alcanzado.");
	}
}
