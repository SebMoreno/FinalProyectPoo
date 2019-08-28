package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;

public class ControlInformacionCuenta extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String cuenta = ControladorVista.getUsuarioActivo().getUsuario();
		try {
			cuenta = Data.searchInTxt("cuentas.txt", ControladorVista.getUsuarioActivo().getUsuario());
		} catch (DatoNoExistenteException ignored) {

		}
		ControladorVista.getPantallaActual().muestraDatos(cuenta);
		ControladorVista.packActualFrame();
	}


}
