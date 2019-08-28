package model.exceptionsapp;

public class NotFillFieldsAdminException extends FillFieldsException {
	public NotFillFieldsAdminException() {
		super("Administrador no ha llenado todos los campos");
	}
}
