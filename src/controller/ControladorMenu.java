package controller;

import controller.inicio.ControladorMenuArchivo;
import view.InterfazPanel;
import view.VistaPrincipal;

public class ControladorMenu implements ControladorVista {

	public static void setControladoresMenu(InterfazPanel p) {
		ControladorVista[] controladores = new ControladorVista[VistaPrincipal.MENU_ARCHIVO.length + VistaPrincipal.MENU_PROCESOS.length + VistaPrincipal.MENU_AYUDA.length];
		controladores[0] = new ControladorMenuArchivo();
		controladores[1] = new ControlLogout();

		for (int i = 0; i < controladores.length-2; i++) {

		}
		p.setController(controladores);
	}

}
