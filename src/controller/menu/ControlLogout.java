package controller.menu;

import controller.ControladorVista;
import controller.inicio.ControlLogin;
import controller.inicio.ControladorInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.Inicio;
import view.VistaPrincipal;

public class ControlLogout extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		VistaPrincipal.MenuApp source = (VistaPrincipal.MenuApp) actionEvent.getSource();
		Inicio i = new Inicio();
		ControladorInicio.setControladoresVistaInicial(i.getBotonSalir());
		ControlLogin.reboot();
		ControladorVista.setUsuarioActivo(null);
		JFrame actual = ControladorVista.getFrameActual();
		actual.dispose();
		i.run();
	}
}
