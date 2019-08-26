package model.ExceptionsApp;

public class NotFillFieldsClientException extends ErrorAplicacion{
	public NotFillFieldsClientException(){
		super("Cliente no ha llenado todos los campos");
	}
}
