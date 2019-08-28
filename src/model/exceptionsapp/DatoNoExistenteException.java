package model.exceptionsapp;

public class DatoNoExistenteException extends ErrorAplicacion {
	public DatoNoExistenteException() {
		super("El dato que busca no existe en la base de datos");
	}
}
