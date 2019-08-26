package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.ExceptionsApp.NotFillFieldsAdminException;
import model.ExceptionsApp.NotFillFieldsClientException;
import model.ExceptionsApp.WrongCredentialsException;
import model.user.Administrador;
import model.user.Usuario;
import view.InterfazBotonInicio;

public class ControlLogin implements ActionListener, ControladorVista {
	private static int loginAdmin;
	private static int loginCliente;
	private static boolean initied = false;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		InterfazBotonInicio i = (InterfazBotonInicio) actionEvent.getSource();
		if (((JButton) i).getText().charAt(0) == 'A') {
			i.isAdminEntering(true);
			loginAdmin++;
			loginCliente--;
		} else {
			i.isAdminEntering(false);
			loginCliente++;
			loginAdmin--;
		}


		if (!initied) {
			initied = initialFieds(i);
		} else {
			if (loginAdmin == 2) {
				try {
					String clave = i.getClave();
					String user = i.getUsuario();
					Usuario.setUsuarioActivo(new Administrador(user, clave));
				} catch (NotFillFieldsAdminException | NotFillFieldsClientException e) {
					i.mostrarError(e.getMessage(), "Algún campo está sin rellenar", JOptionPane.WARNING_MESSAGE);
					loginAdmin--;
					loginCliente++;
				}catch (WrongCredentialsException e){
					i.mostrarError(e.getMessage(), "Credenciales Incorrectas", JOptionPane.ERROR_MESSAGE);
					loginAdmin--;
					loginCliente++;
				}
			} else if (loginCliente == 2) {
				try {
					String clave = i.getClave();
					String user = i.getUsuario();
					Usuario.setUsuarioActivo(new Administrador(user, clave));//TODO cambiar a Cliente
				} catch (NotFillFieldsAdminException | NotFillFieldsClientException e) {
					i.mostrarError(e.getMessage(), "Algún campo está sin rellenar", JOptionPane.WARNING_MESSAGE);
					loginCliente--;
					loginAdmin++;
				}catch (WrongCredentialsException e){
					i.mostrarError(e.getMessage(), "Credenciales Incorrectas", JOptionPane.ERROR_MESSAGE);
					loginCliente--;
					loginAdmin++;
				}
			}
		}

		i.packInicio();
		// TODO hacer que se inicie la sesion Y la excepcion
	}

	private boolean initialFieds(InterfazBotonInicio i) {
		i.apareceFormulario();
		if (loginAdmin ==1){
			loginCliente++;
		}else {
			loginAdmin++;
		}
		return true;
	}
}
