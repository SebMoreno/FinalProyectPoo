package controller.inicio;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.user.Usuario;
import view.VistaPrincipal;

public class ControladorMenuArchivo implements ControladorVista, ActionListener {
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		VistaPrincipal.MenuApp source = (VistaPrincipal.MenuApp) actionEvent.getSource();
		source.mostrarInfoUser(Usuario.getUsuarioActivo().getUsuario() + " " + Usuario.getUsuarioActivo().getRol() + " " + Usuario.getUsuarioActivo().getNombre() + " " + Usuario.getUsuarioActivo().getEmail());
	}
}
