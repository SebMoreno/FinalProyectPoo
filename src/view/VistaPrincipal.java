package view;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame {
	/*
	 * public static final HashMap<String, OpcionDeMenu> menu_generico = new HashMap<>();  // HM con todas las opciones de menu existentes
	 * private static MenuDeConsola menuInicial; //Un menu que se abra inicialmente
	 * */
	JPanel pantallaActual;

	public void run() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
