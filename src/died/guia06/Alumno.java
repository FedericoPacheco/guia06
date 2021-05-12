package died.guia06;

import java.util.ArrayList;

public class Alumno {

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
	
	public int creditosObtenidos() {
		
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
		Integer posicionEnCursando;
		Curso cursoAprobado;
		
		Arrays.sort(cursando, (Curso c1, Curso c2) -> c1.getId().compareTo(c2.getId()));
		posicionEnCursando = Arrays.binarySearch(cursando, (Curso c1, Curso c2) -> c1.getId().compareTo(c2.getId()));
		
		cursoAprobado = cursando.get(posicionEnCursando);
		aprobados.add(cursoAprobado);
		cursando.remove(posicionEnCursando);
	}
	
	public Integer incripcionesEnCicloLectivo(Integer cicloLectivo)
	{
		return
				cursando
				.stream()
				.filter((Curso c) -> c.getCicloLectivo().equals(cicloLectivo))
				.count();
	}

	public void toString()
	{
		return "[" + nombre + "; " + nroLibreta + "; " + this.creditosObtenidos() + "]";
	}
	
	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	
	

}
