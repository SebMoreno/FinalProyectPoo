
package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.user.Usuario;
import view.UsuarioAdministrador.RecargarSaldo;




public class ControlRecargar extends ControladorVista implements ActionListener {
    
    
    @Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
                RecargarSaldo panel = (RecargarSaldo)ControladorVista.getPantallaActual();
                Usuario activo = ControladorVista.getUsuarioActivo();
                String Valor;
                Valor = panel.campo_texto.getText();
                /*
                try {

				if (Data.deleteInTxt("funciones.txt",(String) panel.getFuncionElegida().getSelectedItem())) {
					ControladorVista.getPantallaActual().muestraDatos("Su saldo fue recargado con exito");
					
				}
					ControladorVista.packActualFrame();

			} catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Funcion
			}*/
        }
                
                
    
}