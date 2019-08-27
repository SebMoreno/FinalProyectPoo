package model.ExceptionsApp;

public class NotFillFieldsClientException extends LoginException {
	public NotFillFieldsClientException() {
		super("Cliente no ha llenado todos los campos");
	}
}
