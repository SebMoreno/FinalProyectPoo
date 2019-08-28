package controller.inicio;

import controller.ControlSalida;
import controller.ControladorVista;
import view.InterfazBotonInicio;

public class ControladorInicio implements ControladorVista {
	public static void setControladoresVistaInicial(InterfazBotonInicio p) {
		ControladorVista[] c = {new ControlBienvenida(), new ControlFoto(), new ControlLogin(), new ControlLogin(), new ControlSalida()};
		p.setController(c);
	}
}
