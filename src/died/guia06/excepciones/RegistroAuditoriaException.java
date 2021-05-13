package died.guia06.excepciones;

@SuppressWarnings("serial")
public class RegistroAuditoriaException extends Exception {

	public RegistroAuditoriaException() {
		super("Error. No se pudo actualizar el registro.");
	}

}
