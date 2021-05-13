package died.guia06.excepciones;

import died.guia06.Alumno;

@SuppressWarnings("serial")
public class CupoDeInscripcionAlumnoAlcanzadoException extends Exception 
{
	public CupoDeInscripcionAlumnoAlcanzadoException(Alumno alumno, Integer cicloLectivo)
	{
		super("Error. El alumno " + alumno.getNombre() + "ya se alcanzó el cupo máximo de inscripciones para el ciclo lectivo" + cicloLectivo);
	}
}
