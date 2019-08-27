package model.ExceptionsApp;

public class WrongCredentialsException extends LoginException {
	public WrongCredentialsException() {
		super("Credenciales incorrectas");
	}
}
