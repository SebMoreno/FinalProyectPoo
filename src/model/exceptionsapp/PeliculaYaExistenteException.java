package model.exceptionsapp;

public class PeliculaYaExistenteException extends ObjetoYaExistenteException {
	public PeliculaYaExistenteException() {
		super("Ya existe una película con ese título");
	}
}
