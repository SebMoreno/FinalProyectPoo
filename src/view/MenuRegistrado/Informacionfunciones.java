/**
 * clase que contiene la vista de la opcion de menu informacion funciones
 *
 * @author: Mariana Betancur
 */
package view.MenuRegistrado;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.InterfazPanel;

public class Informacionfunciones extends JPanel implements InterfazPanel {

	/**
	 * cosas que contiene el panel
	 */
	private JButton go = new JButton("GO");
	private JLabel Descripcion = new JLabel();
	private JComboBox elegir_pelicula = new JComboBox();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der = new JPanel();


	/**
	 * contructor de la clase , organiza los paneles
	 */
	public Informacionfunciones() {

		this.setLayout(new BorderLayout(7, 15));


		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));

		Titulo.setText("ELIJA SU PELICULA");
		Descripcion.setText("INFORMACIÓN FUNCIONES");

		// TODO EL BOTON JComboBox HAY QUE LLENARLO CON LAS PELICULAS A ESCOGER
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(elegir_pelicula, BorderLayout.CENTER);
		panel_izq.add(go, BorderLayout.SOUTH);

		panel_der.add(Descripcion, BorderLayout.NORTH);
		

		add(panel_izq, BorderLayout.WEST);
		add(panel_der, BorderLayout.CENTER);
		/* Fin Agregado de Componentes */
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

		JTextArea funcio = new JTextArea();
		JScrollPane panelDescripcion = new JScrollPane();
		String[] datos = textoParaMostrar.split("\n");
		for(int i = 0; i<datos.length;i++) {
			String DatosCompletos = datos[0];
			String data [] = DatosCompletos.split(" ");
			funcio.append("TITULO PELICULA: "+data[2]+ " FUNCION: "+data[0]+" SALA: "+data[1]+" HORA: "+data[3]);
		}
		panel_der.add(panelDescripcion, BorderLayout.CENTER);
	}

	private class PanelFunciones extends JPanel {

		public JPanel auxiliar ;

		PanelFunciones() {
                        auxiliar = new JPanel();
			setLayout(new BorderLayout(7, 15));
			auxiliar.setBackground(Color.WHITE);
			add(auxiliar);

			//TODO llenar el panel con la informacion de las funciones

		}


	}


}





