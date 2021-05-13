package died.guia06;

import java.util.concurrent.TimeUnit;

public class App 
{
	// https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
	// Si imprimo todo junto es un desastre
	public static void main(String[] args) throws InterruptedException
	{
		AlumnoTest test = new AlumnoTest();
		
		test.testInscripcion1();
		test.imprimirInscriptos1();
		test.testInscripcion2();
		
		TimeUnit.SECONDS.sleep(5);
		
		test.testAprobar1();
		test.testInscripcion2();
		test.imprimirInscriptos2();
		
		TimeUnit.SECONDS.sleep(5);
		
		test.testCreditosObtenidos();
		test.testAprobar2();
		test.testCreditosObtenidos();
	}
}
