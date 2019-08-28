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

public class InformacionPeliculas extends JPanel implements InterfazPanel {

	private JButton go = new JButton("Ver información de ésta película");
	private JLabel Descripcion = new JLabel();
	private JComboBox elegir_pelicula = new JComboBox();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der = new JPanel();

	public JComboBox getPeliculaElegida() {
		return elegir_pelicula;
	}

	/**
	 * contructor de la clase , organiza los paneles
	 */
	public InformacionPeliculas() {

		this.setLayout(new BorderLayout(7, 15));

		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));

		Titulo.setText("ELIJA SU PELICULA");
		Descripcion.setText("INFORMACIÓN PELICULAS");

		setPreferredSize(new Dimension(400, 400));
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
	 * @param controllers se necesita un actionListener para el boton go este boton debe
	 *                    mostrar la informacion de las funciones seleccionadas
	 *                    anteriormente
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


		String[] peliculas = textoParaMostrar.split("\n");
		String[] datospelicula;
		if (peliculas[0].equals("Las_Peliculas_son:")) {


			for (int i = 1; i < peliculas.length; i++) {
				datospelicula = peliculas[i].split(" ");

				elegir_pelicula.addItem(datospelicula[0]);
			}

		} else {
			datospelicula = peliculas[0].split(" ");
			JTextArea funcio = new JTextArea();
			JScrollPane panelDescripcion = new JScrollPane(funcio);

			funcio.append("TITULO PELICULA: " + datospelicula[0] + "\n GENERO: " + datospelicula[1] + "\n CLASIFICACION: " + datospelicula[2] + "\n DURACION: " + datospelicula[3] + "\n IDIOMA: " + datospelicula[4]);
			//panelDescripcion.add(funcio);
			if (panel_der.getComponents().length == 2) {
				panel_der.remove(1);
			}
			panel_der.add(panelDescripcion, BorderLayout.CENTER);
		}
	}

	public class PanelPelicula extends JPanel {

		public JPanel auxiliar;

		PanelPelicula() {
			auxiliar = new JPanel();
			setLayout(new BorderLayout(7, 15));
			auxiliar.setBackground(Color.WHITE);
			add(auxiliar);
			//add(panel_der,BorderLayout.CENTER);
			// TODO llenar el panel con la informacion de las funciones

		}

	}

}
