package view.UsuarioAdministrador;


import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEliminarPelicula extends JPanel {
	/**
	 * cosas que contiene el panel
	 */
	private JButton go = new JButton("Eliminar");
	private Choice elegir_pelicula = new Choice();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();


	/**
	 * constructor que agrega todas las cosas al panel
	 */
	public PanelEliminarPelicula() {

		this.setLayout(new BorderLayout(7, 15));
		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		Titulo.setText("                           ELIJA SU PELICULA");

		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(go, BorderLayout.SOUTH);
		/**
		 * EL BOTON CHOICE HAY QUE LLENARLO CON LAS PELICULAS A ESCOGER
		 */
		panel_izq.add(elegir_pelicula, BorderLayout.CENTER);
		this.add(panel_izq, BorderLayout.CENTER);


	}

}