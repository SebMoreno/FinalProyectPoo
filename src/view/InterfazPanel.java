package view;

import controller.ControladorVista;

public interface InterfazPanel {
	int Salir = 0;

	/*
	 * Metodo que relaciona cada componente que necesita ser controlado con su respectiva clase controladora (Listener)
	 */
	void setController(ControladorVista[] controllers);

	/*
	 * Metodo para poder mostrar en el respectivo panel la información entregada
	 * Si se tiene que devolver feedback al mostrar algo, se devuelve en forma de entero, sino regresa -1
	 */
	void muestraDatos(String textoParaMostrar);
}
