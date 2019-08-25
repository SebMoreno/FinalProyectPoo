package view;

import controller.ControladorVista;

public interface InterfazPanel {
	/*
	 * Metodo que relaciona cada componente que necesita ser controlado con su respectiva clase controladora (Listener)
	 */
	void setController(ControladorVista[] controllers);

	/*
	 * Metodo para poder mostrar en el respectivo panel la información entregada
	 */
	void muestraDatos(String textoParaMostrar);
}
