package model.exceptionsapp;

public class ErrorAplicacion extends Exception {
	public ErrorAplicacion(String message) {
		super("Manejo de Errores de la Aplicación:\n" + message);

	}
}
