/**
 * Vista de la opcion de menu que permite al administrador crear funciones
 *
 * @author Cristian Mejia
 */
package view.UsuarioAdministrador;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import view.InterfazPanel;

public class ComprarBoleta extends JPanel implements InterfazPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
	public JTextField entrada = new JTextField(); // sera el campo de texto donde el usuario ingrese lo solicitado
	public JLabel Titulo = new JLabel(); // este label dira la información de que se esta mostrando, es decir, se muestran las peliculas, las funciones, y las sillas
	/**
	 * clase auxiliar para la creacion de paneles
	 *
	 * @author Cristian mejia
	 */
	JTextArea impresion = new JTextArea();
	//los eventos se controlarán cuando el usuario presione enter
	private JLabel answer = new JLabel("Escoja una pelicula escribiendo el titulo de la pelicula exactamente como aparece"); // Este label debe decir que debe ingresar el usuario
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der_center = new JPanel();
	/* Fin declaraciÃ³n */
	private JPanel panel_der = new JPanel();
	/**
	 * inicio implementacion metodos de la interfaz
	 */

	public JTextField getEntrada() {
		return entrada;
	}

	/**
	 * Constructor de la clase , agrega los objetos mencionados anteriormente en el panel
	 */

	public ComprarBoleta() {
		/* OrganizaciÃ³n de Layout */
		this.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der_center.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));
		Titulo.setText("Listado de Películas");
		impresion.setPreferredSize(new Dimension(300, 800));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(new PanelTexto(), BorderLayout.CENTER);
		this.add(panel_izq, BorderLayout.CENTER);

		panel_der_center.add(answer, BorderLayout.CENTER);
		panel_der_center.add(entrada, BorderLayout.SOUTH);

		panel_der.add(new JPanel(), BorderLayout.NORTH);
		panel_der.add(new JPanel(), BorderLayout.SOUTH);
		panel_der.add(panel_der_center, BorderLayout.CENTER);

		this.add(panel_der, BorderLayout.EAST);

	}

	/**
	 * Metodo de los controladores
	 *
	 * @param controllers
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
entrada.addActionListener((ActionListener) controllers[0]);
	}

	public JTextArea getImpresion() {
		return impresion;
	}

	/**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {
		JOptionPane.showMessageDialog(this, textoParaMostrar, "¡Atención!", JOptionPane.WARNING_MESSAGE);
	}

	public JLabel getTitulo() {
		return Titulo;
	}

	public JLabel getAnswer() {
		return answer;
	}

	class PanelTexto extends JPanel {
		/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */

		JScrollPane scroll = new JScrollPane(); //scroll para el textArea
		/* Fin declaraciÃ³n */

		public PanelTexto() {
			/* OrganizaciÃ³n de Layout */
			this.setLayout(new BorderLayout(0, 0));
			/* Fin Layout */

			/* Operaciones Adicionales */
			ComprarBoleta.this.impresion.setEditable(false); // para que el usuario no pueda ingresar texto
			scroll.setViewportView(ComprarBoleta.this.impresion); //añadir el scroll al textArea
			ComprarBoleta.this.impresion.append(""); // aqui debe ir la informacion que hay que mostrar, es decir, las peliculas disponibles, las sillas disponibles y las funciones existentes.
			/* Fin Operaciones Adicionales */

			/* Agregado de Componentes */
			this.add(ComprarBoleta.this.impresion, BorderLayout.CENTER);
			/* Fin Agregado de Componentes */

		}


	}
}
