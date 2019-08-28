package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import view.UsuarioAdministrador.EliminarFuncion;
import view.UsuarioAdministrador.EliminarPelicula;

public class ControlEliminar extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
		if (source.getText().charAt(source.getText().length() - 1) == 'a') {
			EliminarPelicula panel = (EliminarPelicula) ControladorVista.getPantallaActual();
			try {
				if (Data.deleteInTxt("peliculas.txt", (String) panel.getPeliculaElegida().getSelectedItem())) {
					ControladorVista.getPantallaActual().muestraDatos("Película borrada con éxito");
					ControladorVista.getPantallaActual().muestraDatos("Las_Peliculas_son:\n" + Data.getAllInTxt("peliculas.txt"));
				}

				ControladorVista.packActualFrame();
			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Pelicula
			}
		} else {
			EliminarFuncion panel = (EliminarFuncion) ControladorVista.getPantallaActual();
			try {
				if (Data.deleteInTxt("funciones.txt", (String) panel.getFuncionElegida().getSelectedItem())) {
					ControladorVista.getPantallaActual().muestraDatos("Función borrada con éxito");
					ControladorVista.getPantallaActual().muestraDatos("Las_Funciones_son:\n" + Data.getAllInTxt("funciones.txt"));
				}
				ControladorVista.packActualFrame();

			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Funcion
			}
		}


	}

}
