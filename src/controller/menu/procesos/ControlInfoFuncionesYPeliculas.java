package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import view.MenuRegistrado.InformacionFunciones;
import view.MenuRegistrado.InformacionPeliculas;

public class ControlInfoFuncionesYPeliculas extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
		if (source.getText().charAt(source.getText().length() - 1) == 'a') {
			InformacionPeliculas panel = (InformacionPeliculas) ControladorVista.getPantallaActual();
			try {
				ControladorVista.getPantallaActual().muestraDatos(Data.searchInTxt("peliculas.txt", (String) panel.getPeliculaElegida().getSelectedItem()));
				ControladorVista.packActualFrame();
			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Pelicula
			}
		} else {
			InformacionFunciones panel = (InformacionFunciones) ControladorVista.getPantallaActual();
			try {
				ControladorVista.getPantallaActual().muestraDatos(Data.searchInTxt("funciones.txt", (String) panel.getFuncionElegida().getSelectedItem()));
				ControladorVista.packActualFrame();
			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Pelicula
			}
		}


	}
}
