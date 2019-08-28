package model.exceptionsapp;

public class WrongCredentialsException extends FillFieldsException {
	public WrongCredentialsException() {
		super("Credenciales incorrectas");
	}
}
