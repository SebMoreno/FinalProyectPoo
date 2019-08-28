package controller;

import controller.inicio.ControladorMenuUserYHelp;
import view.InterfazPanel;
import view.VistaPrincipal;

public class ControladorMenu implements ControladorVista {

	public static void setControladoresMenu(InterfazPanel p) {
		ControladorVista[] controladores = new ControladorVista[VistaPrincipal.MENU_ARCHIVO.length + VistaPrincipal.MENU_PROCESOS.length + VistaPrincipal.MENU_AYUDA.length];
		controladores[0] = new ControladorMenuUserYHelp();
		controladores[1] = new ControlLogout();

		for (int i = 0; i < controladores.length-2; i++) {

		}
		controladores[controladores.length-1] = new ControladorMenuUserYHelp();
		p.setController(controladores);
	}

}
