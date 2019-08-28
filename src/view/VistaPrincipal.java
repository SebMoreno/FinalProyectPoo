package view;


import controller.ControladorVista;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame implements InterfazPanel {
	public static final String[] MENU_ARCHIVO = {"Usuario", "Salir"};
	public static final String[] MENU_AYUDA = {"Acerca de"};
	/*
	 * public static final HashMap<String, OpcionDeMenu> menu_generico = new HashMap<>();  // HM con todas las opciones de menu existentes
	 * private static MenuDeConsola menuInicial; //Un menu que se abra inicialmente
	 * */
	private static final String[] MENU_PRINCIPAL = {"Archivo", "Procesos y Consultas", "Ayuda"};
	public static String[] MENU_PROCESOS;
	private InterfazPanel pantallaActual;

	public VistaPrincipal(String usuarioActivo, String[] capacidadesUsuario, InterfazPanel vistaActual) {
		super(usuarioActivo);
		MENU_PROCESOS = capacidadesUsuario;
		setSize(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(capacidadesUsuario);
		setVistaActual(vistaActual);
	}

	public void setVistaActual(InterfazPanel vistaActual) {
		getContentPane().removeAll();
		add((JPanel) vistaActual);
		pantallaActual = vistaActual;
	}

	public void run() {
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}

	private void setJMenuBar(String[] menu_procesos_y_consultas) {
		JMenuBar menuP = new JMenuBar();
		MENU_PROCESOS = menu_procesos_y_consultas;
		for (String menu :
				MENU_PRINCIPAL) {
			menuP.add(new JMenu(menu));

		}

		for (String nombre :
				MENU_ARCHIVO) {
			menuP.getMenu(0).add(new MenuApp(nombre));
		}
		for (String nombre :
				MENU_PROCESOS) {
			menuP.getMenu(1).add(new MenuApp(nombre));
		}
		for (String nombre :
				MENU_AYUDA) {
			menuP.getMenu(2).add(new MenuApp(nombre));
		}


		super.setJMenuBar(menuP);
	}

	@Override
	public void setController(ControladorVista[] controllers) {
		int i = 0;
		int j = 0;
		for (String nombre :
				MENU_ARCHIVO) {
			getJMenuBar().getMenu(0).getItem(j).addActionListener((ActionListener) controllers[i]);
			i++;
			j++;
		}
		j = 0;
		for (String nombre :
				MENU_PROCESOS) {
			getJMenuBar().getMenu(1).getItem(j).addActionListener((ActionListener) controllers[i]);
			i++;
			j++;
		}
		j = 0;
		for (String nombre :
				MENU_AYUDA) {
			getJMenuBar().getMenu(2).getItem(j).addActionListener((ActionListener) controllers[i]);
			i++;
			j++;
		}
	}

	@Override
	public void muestraDatos(String textoParaMostrar) {
		pantallaActual.muestraDatos(textoParaMostrar);
	}

	public class MenuApp extends JMenuItem {
		public MenuApp(String nombre) {
			super(nombre);
		}

		/**
		 * TODO , PONERLO BONITO
		 *
		 * @param infoUsuario
		 */
		public void mostrarInfoAuxiliar(String infoUsuario) {
			if (infoUsuario.equals("Acerca De")) {
				JOptionPane.showMessageDialog(VistaPrincipal.this, "AUTORES :  MARIANA BETANCUR ,CRISTIAN MEJIA , SEBASTIAN MORENO , JAIRO ANDRES");
			} else {

				String info[] = infoUsuario.split(" ");
				JOptionPane.showMessageDialog(VistaPrincipal.this, "USER: " + info[0] + " ROL: " + info[1] + " NOMBRE: " + info[2] + " CORREO: " + info[3]);
			}
		}

		public JFrame getActualFrame() {
			return VistaPrincipal.this;
		}
	}
}
