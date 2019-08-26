package controller;

import view.InterfazPanel;

public class ControladorInicio implements ControladorVista {
	public static void setControladoresVistaInicial(InterfazPanel p) {
		ControladorVista[] c = {new ControlBienvenida(),new ControlFoto(), new ControlFormulario(), new ControlFormulario(), new ControlSalida()};
		p.setController(c);
	}
}
