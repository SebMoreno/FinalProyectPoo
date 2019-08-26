package model.ExceptionsApp;

public class WrongCredentialsException extends ErrorAplicacion {
	public WrongCredentialsException(){
		super("Credenciales incorrectas");
	}
}
