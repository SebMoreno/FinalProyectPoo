package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Inicio;

public class ControlFormulario implements ActionListener, ControladorVista {
	private static int login;
	private static boolean initied = false;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Inicio.LoginButton i = (Inicio.LoginButton) actionEvent.getSource();
		if (i.getText().charAt(0) == 'A') {
			i.isAdminEntering(true);
			login++;
		} else {
			i.isAdminEntering(false);
			login--;
		}
/*
		if (login > 0) {
			new Cliente();
		} else {
			new Administrador();
		}*/

		if (!initied) {
			initied = initialFieds(i);
		}
		i.packInicio();
		// TODO hacer que se inicie la sesion Y la excepcion
	}

	private boolean initialFieds(Inicio.LoginButton i) {
		i.apareceFormularioInicio();
		return true;
	}
}
