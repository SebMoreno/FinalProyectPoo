package controller;

import controller.menu.ControlLogout;
import controller.menu.ControladorMenuUserYHelp;
import controller.menu.procesos.ControlAñadir;
import controller.menu.procesos.ControlCompraBoletas;
import controller.menu.procesos.ControlEliminar;
import controller.menu.procesos.ControlInfoFuncionesYPeliculas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.database.Data;
import view.InterfazPanel;
import view.MenuRegistrado.InformacionCuenta;
import view.MenuRegistrado.InformacionFunciones;
import view.MenuRegistrado.InformacionPeliculas;
import view.UsuarioAdministrador.AñadirPelicula;
import view.UsuarioAdministrador.ComprarBoleta;
import view.UsuarioAdministrador.CrearFuncion;
import view.UsuarioAdministrador.EliminarFuncion;
import view.UsuarioAdministrador.EliminarPelicula;
import view.UsuarioAdministrador.RecargarSaldo;
import view.VistaPrincipal;

public class ControladorMenu extends ControladorVista implements ActionListener {

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
				ControladorVista.setPantallaActual(new InformacionPeliculas());
				ControladorVista.getPantallaActual().muestraDatos("Las_Peliculas_son:\n" + Data.getAllInTxt("peliculas.txt"));
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlInfoFuncionesYPeliculas()});
				break;
			case "Listado de Funciones":
				ControladorVista.setPantallaActual(new InformacionFunciones());
				ControladorVista.getPantallaActual().muestraDatos("Las_Funciones_son:\n" + Data.getAllInTxt("funciones.txt"));
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlInfoFuncionesYPeliculas()});
				break;
			case "Comprar Boleta":
				ControladorVista.setPantallaActual(new ComprarBoleta());
				((ComprarBoleta)ControladorVista.getPantallaActual()).getImpresion().append(ControladorVista.listadoPeliculas());
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlCompraBoletas()});
				ControladorVista.packActualFrame();
				break;
			case "Mostrar la Información de mi cuenta":  //TODO hacer funcionalidad
				ControladorVista.setPantallaActual(new InformacionCuenta());
				break;
			case "Recargar Saldo":  //TODO hacer funcionalidad
				ControladorVista.setPantallaActual(new RecargarSaldo());
				break;
			case "Añadir Película":
				ControladorVista.setPantallaActual(new AñadirPelicula());
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlAñadir()});
				break;
			case "Eliminar Película":
				ControladorVista.setPantallaActual(new EliminarPelicula());
				ControladorVista.getPantallaActual().muestraDatos("Las_Peliculas_son:\n" + Data.getAllInTxt("peliculas.txt"));
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlEliminar()});
				break;
			case "Crear Función":
				ControladorVista.setPantallaActual(new CrearFuncion());
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlAñadir()});
				break;
			case "Eliminar Función":
				ControladorVista.setPantallaActual(new EliminarFuncion());
				ControladorVista.getPantallaActual().muestraDatos("Las_Funciones_son:\n" + Data.getAllInTxt("funciones.txt"));
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlEliminar()});
				break;
		}
	}

}
