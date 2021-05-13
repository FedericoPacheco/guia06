package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import died.guia06.excepciones.CreditosInsuficientesException;
import died.guia06.excepciones.CupoCursoCubiertoException;
import died.guia06.excepciones.CupoDeInscripcionAlumnoAlcanzadoException;
import died.guia06.excepciones.RegistroAuditoriaException;
import died.guia06.util.Registro;

public class Curso 
{
	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos, Integer creditosRequeridos)
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Boolean inscribirAlumno(Alumno alumno) 
		   throws 
		   		CupoDeInscripcionAlumnoAlcanzadoException, 
		   		CupoCursoCubiertoException, 
		   		CreditosInsuficientesException, 
		   		RegistroAuditoriaException 
	{
		Boolean puedeIncribirse = false;
		
		if (alumno.creditosObtenidos() >= creditosRequeridos)
			if (inscriptos.size() + 1 <= cupo)
				if (alumno.incripcionesEnCicloLectivo(cicloLectivo) <= 3)
					puedeIncribirse = true;
				else
					throw new CupoDeInscripcionAlumnoAlcanzadoException(alumno, cicloLectivo);
			else
				throw new CupoCursoCubiertoException(this);
		else 
			throw new CreditosInsuficientesException(alumno, this);
		
		if (puedeIncribirse)
		{
			inscriptos.add(alumno);
			alumno.agregarCurso(this);
			
			try {
				log.registrar(this, "inscribir ",alumno.toString());
			}
			catch (IOException e) {
				throw new RegistroAuditoriaException();
			}
		}
		
		return puedeIncribirse;		
	}
	
	
	// comparator hechos con lambda para compactar
	public void imprimirInscriptosAlfabeticamente() {
		this.imprimirInscriptos((Alumno a1, Alumno a2) -> a1.getNombre().compareTo(a2.getNombre()));
	}
	public void imprimirInscriptosPorLibretaUniversitaria() {
		this.imprimirInscriptos((Alumno a1, Alumno a2) -> a1.getNroLibreta().compareTo(a2.getNroLibreta()));
	}
	public void imprimirInscriptosPorCreditosObtenidos() {
		this.imprimirInscriptos((Alumno a1, Alumno a2) -> a1.creditosObtenidos().compareTo(a2.creditosObtenidos()));
	}
	
	private void imprimirInscriptos(Comparator<Alumno> criterio)
	{
		inscriptos
			.stream()
			.sorted(criterio)
			.forEach((Alumno a) -> System.out.println(a.toString()));
		
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}
		catch (IOException e) {
			System.out.println("Error. No se pudo actualizar el registro.");
		}
	}

	public Integer getId() 										  { return id; 									  }
	public void setId(Integer id)	 							  {	this.id = id; 								  }
	public String getNombre() 									  {	return nombre;								  }
	public void setNombre(String nombre)						  { this.nombre = nombre; 						  }
	public Integer getCicloLectivo() 							  { return cicloLectivo; 						  }
	public void setCicloLectivo(Integer cicloLectivo) 			  {	this.cicloLectivo = cicloLectivo; 			  }
	public Integer getCupo()									  { return cupo; 								  }
	public void setCupo(Integer cupo) 							  {	this.cupo = cupo;							  }
	public Integer getCreditos() 								  { return creditos; 							  }
	public void setCreditos(Integer creditos) 					  { this.creditos = creditos; 					  }
	public Integer getCreditosRequeridos() 						  { return creditosRequeridos; 					  }
	public void setCreditosRequeridos(Integer creditosRequeridos) { this.creditosRequeridos = creditosRequeridos; }
}
