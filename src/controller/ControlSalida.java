package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.InterfazBotonInicio;
import view.InterfazPanel;

public class ControlSalida implements ActionListener, ControladorVista {
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		InterfazBotonInicio i = (InterfazBotonInicio) actionEvent.getSource();
		i.muestraDatos("¿Desea salir del programa?");
		if
		(i.quiereSalir() == InterfazPanel.Salir) {

			System.exit(0);
			// TODO Hacer que se salga el programa GUARDANDO todo
		}
	}
}
