package model.exceptionsapp;

public class NotFillFieldsClientException extends LoginException {
	public NotFillFieldsClientException() {
		super("Cliente no ha llenado todos los campos");
	}
}
