package model.ExceptionsApp;

public class LoginException extends ErrorAplicacion {
	public LoginException(String message) {
		super("Error de Tipo Login:\n" + message);
	}

}
