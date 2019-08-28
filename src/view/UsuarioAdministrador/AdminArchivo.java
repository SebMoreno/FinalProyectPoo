package view.UsuarioAdministrador;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.InterfazPanel;

public class AdminArchivo extends JPanel implements InterfazPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
	JPanel panel_center = new JPanel();
	JPanel panel_down = new JPanel();
	String labels[] = {"Nombre", "Nombre Admin", "Rol", "Administrador", "Correo", "Correo Admin"};
	//nombre admin y correo admin pueden cambiarse a usuarioactivo.nombre o algo asi como en el proyecto pasado
	//el caso es que nombre admin y correo admin se cambien por el nombre y correo del usuario admin
	JButton salir = new JButton("Salir");
	/* Fin declaraciÃ³n */

	public AdminArchivo() {
		/* OrganizaciÃ³n de Layout */
		this.setLayout(new BorderLayout(7, 15));
		panel_down.setLayout(new BorderLayout(7, 15));
		panel_center.setLayout(new GridLayout(3, 2));
		/* Fin Layout */

		/* Operaciones Adicionales */
		setPreferredSize(new Dimension(600, 800));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		for (String i : labels) {
			panel_center.add(new JLabel(i));
		}
		this.add(panel_center, BorderLayout.CENTER);

		panel_down.add(salir, BorderLayout.CENTER);
		this.add(panel_down, BorderLayout.SOUTH);
		/* Fin Agregado de Componentes */


		//Si es un JFrame colocar lo siguiente
		/*


		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Ojo con esta linea, eliminar al finalizar el diseÃ±o
		setSize(700, 500);                                         // setSize(int tamaÃ±oX, int tamaÃ±oY);
		setVisible(true);

		 */
	}

	/* Metodos auxiliares */
	/* Fin Metodos auxiliares */

	@Override
	public void setController(ControladorVista[] controllers) {
		salir.addActionListener((ActionListener) controllers[0]);
	}

	@Override
	public void muestraDatos(String textoParaMostrar) {
		//TERMINAR
	}


}
