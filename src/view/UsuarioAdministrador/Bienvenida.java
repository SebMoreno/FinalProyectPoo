package view.UsuarioAdministrador;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.InterfazPanel;

/**
 * @author Cristianm120
 */
public class Bienvenida extends JPanel implements InterfazPanel {
	/* Empieza declaración de subobjetos pertenencientes a este objeto principal */
	JLabel label = new JLabel("Bienvenido /n El equipo de /n CineX /n está entusiasmado /n con su visita /n DISFRUTE");
	Panel panel = new Panel("fondo.gif");
	JButton boton = new JButton("Continuar");
	/* Fin declaración */

	public Bienvenida() {
		/* Organización de Layout */
		this.setLayout(new BorderLayout(7, 15));
		panel.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		setPreferredSize(new Dimension(600, 600));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel.add(label, BorderLayout.CENTER);
		panel.add(boton, BorderLayout.SOUTH);
		this.add(panel, BorderLayout.CENTER);
		/* Fin Agregado de Componentes */


		//Si es un JFrame colocar lo siguiente
		/*


		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Ojo con esta linea, eliminar al finalizar el diseÃ±o
		setSize(700, 500);                                         // setSize(int tamaÃ±oX, int tamaÃ±oY);
		setVisible(true);

		 */
	}

	@Override
	public void setController(ControladorVista[] controllers) {
		boton.addActionListener((ActionListener) controllers[0]);
	}

	@Override
	public void muestraDatos(String textoParaMostrar) {
		//TERMINAR
	}

	/* Metodos auxiliares */

	/* Fin Metodos auxiliares */

	class Panel extends JPanel {
		ImageIcon imagen;
		String nombre;

		Panel(String nombre) {
			this.nombre = nombre;
		}

		public void paint(Graphics g) {
			Dimension tamaño = getSize();
			imagen = new ImageIcon(getClass().getResource("fondo.gif"));//Antes
			imagen = new ImageIcon("fondo.gif");//Despues
			g.drawImage(imagen.getImage(), 0, 0, tamaño.width, tamaño.height, null);
			setOpaque(false);
			super.paint(g);
		}
	}

}

