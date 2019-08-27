package view.MenuRegistrado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ControladorVista;
import view.InterfazPanel;
import view.MenuRegistrado.InformacionPeliculas.PanelFunciones;

public class InformacionPeliculas extends JPanel implements InterfazPanel {

	private JButton go = new JButton("GO");
	private JLabel Descripcion = new JLabel();
	private JComboBox elegir_pelicula = new JComboBox();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der = new JPanel();

	/**
	 * contructor de la clase , organiza los paneles
	 */
	public InformacionPeliculas() {

		this.setLayout(new BorderLayout(7, 15));

		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));

		Titulo.setText("ELIJA SU PELICULA");
		Descripcion.setText("INFORMACI”N PELICULAS");

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
	 * @param controllers
	 *            se necesita un actionListener para el boton go este boton debe
	 *            mostrar la informacion de las funciones seleccionadas
	 *            anteriormente
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

//		String[] datos = textoParaMostrar.split("\n");
//		String[]datos = "EndGame acci√≥n PG13 3:03 ingl√©s\r\nAladin infantil PG13 2:00 espa√±ol\r\nAvatar acci√≥n R 2:30 ingl√©s".split("\n");
//		for (int i = 0; i < datos.length; i++) {
//			String peliculis = datos[0];
//			String[] lista2 = peliculis.split(" ");
//			JLabel NOMBRE = new JLabel("Pelicula");
//			JLabel nombre = new JLabel(lista2[0]);
//			JLabel GENERO = new JLabel("Genero");
//			JLabel genero = new JLabel(lista2[1]);
//			JLabel CLASIFICACION = new JLabel("ClacificaiÛn");
//			JLabel clasificacion = new JLabel(lista2[2]);
//			JLabel DURACION = new JLabel("DuraciÛn");
//			JLabel duracion = new JLabel(lista2[3]);
//			JLabel IDIOMA = new JLabel("Idioma");
//			JLabel idioma = new JLabel(lista2[4]);
//			JPanel auxiliar = new PanelFunciones();
//			auxiliar.add(NOMBRE);
//			auxiliar.add(nombre);
//			auxiliar.add(GENERO	);
//			auxiliar.add(genero);
//			auxiliar.add(CLASIFICACION);
//			auxiliar.add(clasificacion);
//			auxiliar.add(DURACION);
//			auxiliar.add(duracion);
//			auxiliar.add(IDIOMA);
//			auxiliar.add(idioma);
//		}
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

	public class PanelFunciones extends JPanel {

		public JPanel auxiliar;

		PanelFunciones() {
			auxiliar = new JPanel();
			setLayout(new BorderLayout(7, 15));
			auxiliar.setBackground(Color.WHITE);
			add(auxiliar);

			// TODO llenar el panel con la informacion de las funciones

		}

	}

}
