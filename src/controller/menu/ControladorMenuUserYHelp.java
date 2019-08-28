package controller.menu;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.VistaPrincipal;

public class ControladorMenuUserYHelp extends ControladorVista implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		VistaPrincipal.MenuApp source = (VistaPrincipal.MenuApp) actionEvent.getSource();
		if (source.getText().equals("Usuario")) {
			source.mostrarInfoAuxiliar(ControladorVista.getUsuarioActivo().getUsuario() + " " + ControladorVista.getUsuarioActivo().getRol() + " " + ControladorVista.getUsuarioActivo().getNombre() + " " + ControladorVista.getUsuarioActivo().getEmail());
		} else {
			source.mostrarInfoAuxiliar("Acerca De");
		}
	}
}
