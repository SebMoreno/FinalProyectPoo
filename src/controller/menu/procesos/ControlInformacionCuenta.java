
package controller.menu.procesos;
import model.user.Usuario;
import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import view.MenuRegistrado.InformacionCuenta;
import controller.ControladorVista.*;
import model.exceptionsapp.DatoNoExistenteException;

public class ControlInformacionCuenta extends ControladorVista implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
		
			InformacionCuenta panel = (InformacionCuenta)ControladorVista.getPantallaActual();
			try {
				ControladorVista.getPantallaActual().muestraDatos(Data.searchInTxt("cuentas.txt",activo.getUsuario()));
				ControladorVista.packActualFrame();
			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Pelicula
			}
		}



	}
