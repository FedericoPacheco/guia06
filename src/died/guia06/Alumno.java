// salvacion:
// https://stackoverflow.com/questions/19696613/getting-jre-system-library-unbound-error-in-build-path

package died.guia06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Alumno implements Comparable<Alumno>
{
	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno (String nombre, Integer nroLibreta)
	{
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		cursando = new ArrayList<Curso>();
		aprobados = new ArrayList<Curso>();
	}
	
	public Integer creditosObtenidos() {
		
		Integer creditosObtenidos = 0;
		
		for (Curso cursosAprobados: aprobados)
			creditosObtenidos += cursosAprobados.getCreditos();
			
		return creditosObtenidos;
	}
	
	public void agregarCurso(Curso c)
	{
		cursando.add(c);
	}
	
	public void aprobarCurso(Curso c)
	{
		int posicionEnCursando;
		Curso cursoAprobado;
		Comparator <Curso> auxComparator = (Curso c1, Curso c2) -> c1.getId().compareTo(c2.getId());
		
		Collections.sort(cursando, auxComparator);
		posicionEnCursando = Collections.binarySearch(cursando, c, auxComparator);
		
		cursoAprobado = cursando.get(posicionEnCursando);
		aprobados.add(cursoAprobado);
		cursando.remove(posicionEnCursando);
	}
	
	public Integer incripcionesEnCicloLectivo(Integer cicloLectivo)
	{
		return
			(int) cursando
					.stream()
					.filter((Curso c) -> c.getCicloLectivo().equals(cicloLectivo))
					.count();
	}

	public String toString()
	{
		return "[" + nombre + "; " + nroLibreta + "; " + this.creditosObtenidos() + "]";
	}
	
	public Boolean equals(Alumno otroAlumno) { return nroLibreta.equals(otroAlumno.getNroLibreta()); }
	
	public String getNombre() 					  { return nombre; }
	public void setNombre(String nombre)		  { this.nombre = nombre; }
	public Integer getNroLibreta() 				  { return nroLibreta; }
	public void setNroLibreta(Integer nroLibreta) { this.nroLibreta = nroLibreta; }

	public int compareTo(Alumno otroAlumno) 
	{
		return nombre.compareTo(otroAlumno.getNombre());
	}
}
