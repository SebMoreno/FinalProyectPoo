package controller.inicio;


import controller.ControladorMenu;
import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.exceptionsapp.NotFillFieldsAdminException;
import model.exceptionsapp.NotFillFieldsClientException;
import model.exceptionsapp.WrongCredentialsException;
import model.user.Administrador;
import model.user.Cliente;
import view.InterfazBotonInicio;
import view.UsuarioAdministrador.Bienvenida;
import view.VistaPrincipal;

public class ControlLogin extends ControladorVista implements ActionListener {
	private static int loginAdmin;
	private static int loginCliente;
	private static boolean initied = false;

	public static void reboot() {
		loginAdmin = 0;
		loginCliente = 0;
		initied = false;
	}

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
					ControladorVista.setUsuarioActivo(new Administrador(user, clave));
					VistaPrincipal inicia = new VistaPrincipal(user, Administrador.getCapacidades(), new Bienvenida("temp/fondo.gif"));//TODO Colocar ventana de bienvenida
					JFrame actual = ControladorVista.getFrameActual();
					actual.dispose();
					ControladorVista.setFrameActual(inicia);
					ControladorMenu.setControladoresMenu(inicia);
					inicia.run();
				} catch (NotFillFieldsAdminException | NotFillFieldsClientException e) {
					i.mostrarError(e.getMessage(), "Algún campo está sin rellenar", JOptionPane.WARNING_MESSAGE);
					loginAdmin--;
					loginCliente++;
				} catch (WrongCredentialsException e) {
					i.mostrarError(e.getMessage(), "Credenciales Incorrectas", JOptionPane.ERROR_MESSAGE);
					loginAdmin--;
					loginCliente++;
				} catch (IOException e) {
					//TODO que hacer cuando no se puede hacer login por falta de archivo txt
				}
			} else if (loginCliente == 2) {
				try {
					String clave = i.getClave();
					String user = i.getUsuario();
					ControladorVista.setUsuarioActivo(new Cliente(user, clave));
					VistaPrincipal inicia = new VistaPrincipal(user, Cliente.getCapacidades(), new Bienvenida("temp/fondo.gif"));//TODO Colocar ventana de bienvenida
					JFrame actual = ControladorVista.getFrameActual();
					actual.dispose();
					ControladorVista.setFrameActual(inicia);
					ControladorMenu.setControladoresMenu(inicia);
					inicia.run();
				} catch (NotFillFieldsAdminException | NotFillFieldsClientException e) {
					i.mostrarError(e.getMessage(), "Algún campo está sin rellenar", JOptionPane.WARNING_MESSAGE);
					loginCliente--;
					loginAdmin++;
				} catch (WrongCredentialsException e) {
					i.mostrarError(e.getMessage(), "Credenciales Incorrectas", JOptionPane.ERROR_MESSAGE);
					loginCliente--;
					loginAdmin++;
				} catch (IOException e) {
					//TODO que hacer cuando no se puede hacer login por falta de archivo txt
				}
			}
		}

		i.packInicio();
	}

	private boolean initialFieds(InterfazBotonInicio i) {
		i.apareceFormulario();
		if (loginAdmin == 1) {
			loginCliente++;
		} else {
			loginAdmin++;
		}
		return true;
	}
}
