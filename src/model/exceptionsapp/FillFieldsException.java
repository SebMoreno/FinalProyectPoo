package model.exceptionsapp;

public class FillFieldsException extends ErrorAplicacion {
	public FillFieldsException(String message) {
		super("Error de Tipo FillFields:\n" + message);
	}

}
