package model.exceptionsapp;

public class NotFillFieldsClientException extends FillFieldsException {
	public NotFillFieldsClientException() {
		super("Cliente no ha llenado todos los campos");
	}
}
