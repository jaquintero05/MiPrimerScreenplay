package co.com.google.certificacion.miprimerscreenplay.exceptions;

public class FraseNoEnContrada extends AssertionError {
	
public static final String franceNoEnContrada="la frase encontrada no correspondea la busqueda";

	public FraseNoEnContrada(String message, Throwable cause  ) {
		// TODO Auto-generated constructor stub
		super (message, cause);
	}

}
