package model.ExceptionsApp;

public class NotFillFieldsAdminException extends LoginException {
	public NotFillFieldsAdminException() {
		super("Administrador no ha llenado todos los campos");
	}
}
