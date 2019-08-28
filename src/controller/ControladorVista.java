package controller;

import controller.inicio.ControlBienvenida;
import controller.inicio.ControlFoto;
import controller.inicio.ControlLogin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.database.Data;
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
		JFrame actual = (JFrame)FrameActual;
		actual.getContentPane().removeAll();
		actual.add((JPanel) pantallaActual);
		actual.pack();
	}
	public static void packActualFrame(){
		JFrame actual = (JFrame)FrameActual;
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
}
