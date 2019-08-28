
package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import view.MenuRegistrado.InformacionCuenta;

public class ControlInformacionCuenta extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
		
			InformacionFunciones panel = (InformacionCuenta)ControladorVista.getPantallaActual();
			try {
				ControladorVista.getPantallaActual().muestraDatos(Data.searchInTxt("funciones.txt",(String) panel.getFuncionElegida().getSelectedItem()));
				ControladorVista.packActualFrame();
			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Pelicula
			}
		}



	}
