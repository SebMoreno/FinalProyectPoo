package view;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame {
	/*
	 * public static final HashMap<String, OpcionDeMenu> menu_generico = new HashMap<>();  // HM con todas las opciones de menu existentes
	 * private static MenuDeConsola menuInicial; //Un menu que se abra inicialmente
	 * */
	private final String[] MENU_PRINCIPAL = {"Archivo", "Procesos y Consultas", "Ayuda"};
	private final String[] MENU_ARCHIVO = {"Usuario", "Salir"};
	private final String[] MENU_AYUDA = {"Acerca de"};
	JPanel pantallaActual;

	public VistaPrincipal(String usuarioActivo, String[] capacidadesUsuario, InterfazPanel vistaActual) {
		super(usuarioActivo);
		setSize(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(capacidadesUsuario);
		setVistaActual(vistaActual);
	}

	public void setVistaActual(InterfazPanel vistaActual) {
		getContentPane().removeAll();
		add((JPanel) vistaActual);
	}

	public void run() {
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}

	private void setJMenuBar(String[] menu_procesos_y_consultas) {
		JMenuBar menuP = new JMenuBar();
		for (String menu :
				MENU_PRINCIPAL) {
			menuP.add(new JMenu(menu));

		}

		for (String nombre :
				MENU_ARCHIVO) {
			menuP.getMenu(0).add(new JMenuItem(nombre));
		}
		for (String nombre :
				menu_procesos_y_consultas) {
			menuP.getMenu(1).add(new JMenuItem(nombre));
		}
		for (String nombre :
				MENU_AYUDA) {
			menuP.getMenu(2).add(new JMenuItem(nombre));
		}


		super.setJMenuBar(menuP);


	}
}
