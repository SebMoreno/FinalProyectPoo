/**
 * clase que contiene la vista de la opcion de menu informacion funciones
 *
 * @author: Mariana Betancur
 */
package view.MenuRegistrado;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import view.InterfazPanel;

public class InformacionFunciones extends JPanel implements InterfazPanel {

	/**
	 * cosas que contiene el panel
	 */
	private JButton go = new JButton("Ver información de ésta función");
	private JLabel Descripcion = new JLabel();
	private JComboBox elegir_funcion = new JComboBox();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der = new JPanel();


	/**
	 * contructor de la clase , organiza los paneles
	 */
	public InformacionFunciones() {

		this.setLayout(new BorderLayout(7, 15));


		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));
		setPreferredSize(new Dimension(400, 400));
		Titulo.setText("ELIJA SU FUNCION");
		Descripcion.setText("INFORMACIÓN FUNCIONES");

		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(elegir_funcion, BorderLayout.CENTER);
		panel_izq.add(go, BorderLayout.SOUTH);

		panel_der.add(Descripcion, BorderLayout.NORTH);


		add(panel_izq, BorderLayout.WEST);
		add(panel_der, BorderLayout.CENTER);
		/* Fin Agregado de Componentes */
	}
	public JComboBox getFuncionElegida() {
		return elegir_funcion;
	}

	/**
	 * IMPLEMENTACION METODOS DE LA INTERFAZ
	 */

	/**
	 * Metodo de los controladores
	 *
	 * @param controllers se necesita un actionListener para el boton go este boton debe mostrar la informacion de las funciones seleccionadas anteriormente
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
		go.addActionListener((ActionListener) controllers[0]);
	}

	/**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {


		String[] funciones = textoParaMostrar.split("\n");
		String[] datosfuncion;
		if (funciones[0].equals("Las_Funciones_son:")) {


			for (int i = 1; i < funciones.length; i++) {
				datosfuncion = funciones[i].split(" ");

				elegir_funcion.addItem(datosfuncion[0]);
			}

		} else {// key: idFuncion     value: idSala, tituloPelicula, hora, sillasOcupadas
			datosfuncion = funciones[0].split(" ");
			JTextArea funcio = new JTextArea();
			JScrollPane panelDescripcion = new JScrollPane();

			funcio.append("TITULO PELICULA: " + datosfuncion[2] + " FUNCION: " + datosfuncion[0] + " SALA: " + datosfuncion[1] + " HORA: " + datosfuncion[3] + " SILLAS OCUPADAS: " + datosfuncion[4]);
			if (panel_der.getComponents().length == 2) {
				panel_der.remove(1);
			}
			panel_der.add(panelDescripcion, BorderLayout.CENTER);
		}
	}

	private class PanelFunciones extends JPanel {

		public JPanel auxiliar;

		PanelFunciones() {
			auxiliar = new JPanel();
			setLayout(new BorderLayout(7, 15));
			auxiliar.setBackground(Color.WHITE);
			add(auxiliar);

			//TODO llenar el panel con la informacion de las funciones

		}


	}


}





