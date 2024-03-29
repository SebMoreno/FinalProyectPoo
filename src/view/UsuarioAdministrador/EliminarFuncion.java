package view.UsuarioAdministrador;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.InterfazPanel;

public class EliminarFuncion extends JPanel implements InterfazPanel {
	private final static HashMap<String, String[]> functionList = new HashMap<>();
	/**
	 * cosas que contiene el panel
	 */
	private JButton go = new JButton("Eliminar Funcion");
	private JComboBox elegir_funcion = new JComboBox();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();

	/**
	 * constructor que agrega todas las cosas al panel
	 */
	public EliminarFuncion() {

		this.setLayout(new BorderLayout(7, 15));
		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		Titulo.setText("                           ELIJA SU FUNCION");
		setPreferredSize(new Dimension(500, 300));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(go, BorderLayout.SOUTH);
		/**
		 * peliculas añadidas
		 */
		panel_izq.add(elegir_funcion, BorderLayout.CENTER);
		this.add(panel_izq, BorderLayout.CENTER);


	}
	/**
	 * inicio implementacion metodos de la interfaz
	 */

	/**
	 * Metodo de los controladores
	 *
	 * @param controllers BOTON QUE ACTIVA EL BORRADO
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
		go.addActionListener((ActionListener) controllers[0]);
	}

	/**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar TODO se tiene que verificar que la informacion suminisrada sea valida para ver cual option pane agregar
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {


		String[] funciones = textoParaMostrar.split("\n");
		String[] datosfuncion;
		if (funciones[0].equals("Las_Funciones_son:")) {
			elegir_funcion.removeAllItems();

			for (int i = 1; i < funciones.length; i++) {
				datosfuncion = funciones[i].split(" ");

				elegir_funcion.addItem(datosfuncion[0]);
			}

		} else {
			JOptionPane.showMessageDialog(this, textoParaMostrar, "¡Alerta!", JOptionPane.WARNING_MESSAGE);
		}
	}

	public JComboBox getFuncionElegida() {
		return elegir_funcion;
	}
}