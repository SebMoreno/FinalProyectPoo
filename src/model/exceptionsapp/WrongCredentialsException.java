package model.exceptionsapp;

public class WrongCredentialsException extends LoginException {
	public WrongCredentialsException() {
		super("Credenciales incorrectas");
	}
}
