package model.exceptionsapp;

public class ObjetoYaExistenteException extends ErrorAplicacion {
	public ObjetoYaExistenteException(String message) {
		super("Error de Tipo ObjetoYaExistente:\n" + message);
	}
}
