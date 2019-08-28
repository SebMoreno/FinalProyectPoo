package controller;

import controller.inicio.ControlLogin;
import controller.inicio.ControladorInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.user.Usuario;
import view.Inicio;
import view.VistaPrincipal;

public class ControlLogout implements ControladorVista, ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		VistaPrincipal.MenuApp source = (VistaPrincipal.MenuApp) actionEvent.getSource();
		Inicio i = new Inicio();
		ControladorInicio.setControladoresVistaInicial(i.getBotonSalir());
		ControlLogin.reboot();
		Usuario.setUsuarioActivo(null);
		source.getActualFrame().dispose();
		i.run();
	}
}
