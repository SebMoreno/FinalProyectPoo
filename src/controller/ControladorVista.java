package controller;

import controller.inicio.ControlBienvenida;
import controller.inicio.ControlFoto;
import controller.inicio.ControlLogin;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.cine.Funcion;
import model.cine.Pelicula;
import model.user.Usuario;
import view.InterfazBotonInicio;
import view.InterfazPanel;

public class ControladorVista {
	private static InterfazPanel pantallaActual;
	private static JFrame FrameActual;
	private static Usuario usuarioActivo;

	public static void setControladoresVistaInicial(InterfazBotonInicio p) {
		ControladorVista[] c = {new ControlBienvenida(), new ControlFoto(), new ControlLogin(), new ControlLogin(), new ControlSalida()};
		p.setController(c);
		FrameActual = p.getActualFrame();
	}

	public static InterfazPanel getPantallaActual() {
		return pantallaActual;
	}

	public static void setPantallaActual(InterfazPanel pantallaActual) {
		ControladorVista.pantallaActual = pantallaActual;
		JFrame actual = FrameActual;
		actual.getContentPane().removeAll();
		actual.add((JPanel) pantallaActual);
		actual.pack();
	}

	public static void packActualFrame() {
		JFrame actual = (JFrame) FrameActual;
		actual.pack();
	}

	public static JFrame getFrameActual() {
		return FrameActual;
	}

	public static void setFrameActual(JFrame frameActual) {
		FrameActual = frameActual;
	}

	public static Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public static void setUsuarioActivo(Usuario usuarioActivo) {
		ControladorVista.usuarioActivo = usuarioActivo;
	}

	public static String listadoPeliculas() {//accede al hash he imprime todas las keys y values(recordar que los values de nuestros hash map son arreglos)
		StringBuilder listado = new StringBuilder();
		if (!Pelicula.getPelisList().isEmpty()) {
			for (Map.Entry<String, String[]> entry : Pelicula.getPelisList().entrySet()) {
				listado.append("************").append(entry.getKey()).append("************");
				listado.append("\n");
				listado.append("genero: ").append(entry.getValue()[0]);
				listado.append("\n");
				listado.append("clasificación: ").append(entry.getValue()[1]);
				listado.append("\n");
				listado.append("duracion: ").append(entry.getValue()[2]);
				listado.append("\n");
				listado.append("idioma: ").append(entry.getValue()[3]);
				listado.append("\n");
			}
		} else {
			listado.append("No hay peliculas ahora mismo");
			listado.append("\n");
		}
		return listado.toString();
	}
	public static String listadoFunciones() {//metodo interesante , lo que esa es imprimir las funciones
		StringBuilder listado = new StringBuilder();
		if (!Funcion.getFuncionesList().isEmpty()) {
			for (Map.Entry<String, String[]> entry : Funcion.getFuncionesList().entrySet()) {
				listado.append("************" + "Funcion ").append(entry.getKey()).append("************");
				listado.append("\n");
				listado.append("Sala: ").append(entry.getValue()[0]);
				listado.append("\n");
				listado.append("Titulo pelicula: ").append(entry.getValue()[1]);
				listado.append("\n");
				listado.append("Hora: ").append(entry.getValue()[2]);
				listado.append("\n");
				listado.append("Sillas ocupadas: ").append(entry.getValue()[3]);
				listado.append("\n");
			}
		} else {
			listado.append("\n");
			listado.append("No hay funciones ahora mismo");
		}
		return listado.toString();
	}

}
