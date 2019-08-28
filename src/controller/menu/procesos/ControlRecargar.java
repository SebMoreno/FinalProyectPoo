package controller.menu.procesos;


import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import model.user.Usuario;
import view.UsuarioAdministrador.RecargarSaldo;

public class ControlRecargar extends ControladorVista implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton source = (JButton) actionEvent.getSource();
		RecargarSaldo panel = (RecargarSaldo) ControladorVista.getPantallaActual();
		Usuario activo = ControladorVista.getUsuarioActivo();
                String usuario=activo.getUsuario();
		String Valor;
		Valor = panel.campo_texto.getText();
                try {
                    
			String datos =(Data.searchInTxt("cuenta.txt", usuario));
                        String[] infousuario = datos.split(" ");
                        String valorreal=infousuario[1];
                        
                        String total=usuario+" "+Valor;
                        String line = null;
                        Data.deleteInTxt("cuentas.txt",usuario);
                        
                        
                        ControladorVista.packActualFrame();
                        
			} 
		          catch (DatoNoExistenteException e) {
				//TODO que hacer cuando no se encuentra un dato de Pelicula
			}
                
                
			}
	}



