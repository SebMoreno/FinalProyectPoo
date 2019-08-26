package model.ExceptionsApp;

public class NotFillFieldsAdminException extends ErrorAplicacion {
	public NotFillFieldsAdminException(){
		super("Administrador no ha llenado todos los campos");
	}
}
