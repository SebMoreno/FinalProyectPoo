
package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import view.UsuarioAdministrador.RecargarSaldo;
import controller.ControladorVista.*;
import static java.lang.Integer.parseInt;
import model.user.Usuario;




public class ControlRecargar extends ControladorVista implements ActionListener {
    
    
    @Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
                RecargarSaldo panel = (RecargarSaldo)ControladorVista.getPantallaActual();
                Usuario activo = ControladorVista.getUsuarioActivo();
                String Valor;
                Valor = panel.campo_texto.getText();
                String[] cuenta = model.user.Cuenta.getCuentasList().get(activo);
                String saldo = cuenta[0];
                try {
				if (Data.searchInTxt("cuentas.txt", activo.getUsuario()).equals(activo + " " + saldo)) {
                                        //saldo = toString(parseInt(saldo)+ parseInt(Valor));
					ControladorVista.getPantallaActual().muestraDatos("Su saldo fue recargado con exito");
					
				}
					ControladorVista.packActualFrame();

			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Funcion
			}
        }
                
                
    
}
