package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.cine.Funcion;
import model.cine.Pelicula;
import model.cine.Sala;
import model.exceptionsapp.DatoNoExistenteException;
import model.exceptionsapp.PeliculaYaExistenteException;
import view.UsuarioAdministrador.AñadirPelicula;
import view.UsuarioAdministrador.CrearFuncion;

public class ControlAñadir extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
		if (source.getText().charAt(source.getText().length() - 1) == 'a') {
			AñadirPelicula panel = (AñadirPelicula) ControladorVista.getPantallaActual();
			try {
				new Pelicula(((AñadirPelicula) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Nombre de la Pelicula"),
						((AñadirPelicula) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Género"),
						((AñadirPelicula) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Clasificación"),
						((AñadirPelicula) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Duración"),
						((AñadirPelicula) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Idioma"));
				ControladorVista.getPantallaActual().muestraDatos("Película creada con éxito");
			} catch (PeliculaYaExistenteException e) {
				ControladorVista.getPantallaActual().muestraDatos(e.getMessage());
			}
		} else {

			CrearFuncion panel = (CrearFuncion) ControladorVista.getPantallaActual();
			try {
				Sala sala = new Sala(((CrearFuncion) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Sala"));
				Pelicula peli = new Pelicula(((CrearFuncion) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Titulo pelicula"));
				new Funcion(sala, ((CrearFuncion) ControladorVista.getPantallaActual()).getFieldPanel().getValue("Hora"), peli);
				ControladorVista.getPantallaActual().muestraDatos("Función creada con éxito");
			} catch (DatoNoExistenteException e) {
				ControladorVista.getPantallaActual().muestraDatos(e.getMessage() + "\nLa sala en la que quiere asignar la funcion no existe o la pelicula con la que quiere crear la función no existe");
			}


		}

	}
}
