package controller.inicio;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.user.Usuario;
import view.VistaPrincipal;

public class ControladorMenuUserYHelp implements ControladorVista, ActionListener {
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		VistaPrincipal.MenuApp source = (VistaPrincipal.MenuApp) actionEvent.getSource();
		if (source.getText().equals("Usuario")) {
			source.mostrarInfoAuxiliar(Usuario.getUsuarioActivo().getUsuario() + " " + Usuario.getUsuarioActivo().getRol() + " " + Usuario.getUsuarioActivo().getNombre() + " " + Usuario.getUsuarioActivo().getEmail());
		}else{
			source.mostrarInfoAuxiliar("Acerca De");
		}
	}
}
