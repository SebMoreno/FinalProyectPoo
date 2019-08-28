package controller;

import controller.menu.ControlLogout;
import controller.menu.ControladorMenuUserYHelp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.InformacionCuenta;
import view.InterfazPanel;
import view.MenuRegistrado.InformacionFunciones;
import view.MenuRegistrado.InformacionPeliculas;
import view.UsuarioAdministrador.AñadirPelicula;
import view.UsuarioAdministrador.ComprarBoleta;
import view.UsuarioAdministrador.CrearFuncion;
import view.UsuarioAdministrador.EliminarPelicula;
import view.UsuarioAdministrador.RecargarSaldo;
import view.VistaPrincipal;

public class ControladorMenu implements ControladorVista, ActionListener {

	public static void setControladoresMenu(InterfazPanel p) {
		ControladorVista[] controladores = new ControladorVista[VistaPrincipal.MENU_ARCHIVO.length + VistaPrincipal.MENU_PROCESOS.length + VistaPrincipal.MENU_AYUDA.length];
		controladores[0] = new ControladorMenuUserYHelp();
		controladores[1] = new ControlLogout();

		for (int i = 2; i < controladores.length - 1; i++) {
			controladores[i] = new ControladorMenu();
		}
		controladores[controladores.length - 1] = new ControladorMenuUserYHelp();
		p.setController(controladores);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		VistaPrincipal.MenuApp source = (VistaPrincipal.MenuApp) actionEvent.getSource();
		switch (source.getText()) {
			case "Listado de Películas":
				source.setVistaActual(new InformacionPeliculas());
				break;
			case "Listado de Funciones":
				source.setVistaActual(new InformacionFunciones());
				break;
			case "Comprar Boleta":
				source.setVistaActual(new ComprarBoleta());
				break;
			case "Mostrar la Información de mi cuenta":
				source.setVistaActual(new InformacionCuenta());//TODO falta panel de la vista Informacion cuenta
				break;
			case "Recargar Saldo":
				source.setVistaActual(new RecargarSaldo());
				break;
			case "Añadir Película":
				source.setVistaActual(new AñadirPelicula());
				break;
			case "Eliminar Película":
				source.setVistaActual(new EliminarPelicula());
				break;
			case "Crear Función":
				source.setVistaActual(new CrearFuncion());
				break;
			case "Eliminar Función":
				source.setVistaActual(new InformacionPeliculas());//TODO falta panel de la vista Eliminar funcion
				break;
		}
	}

}
