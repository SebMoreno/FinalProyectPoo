package view.UsuarioAdministrador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminProcesos extends JPanel {  //al iniciar sesion por defecto se muestra esta pantalla
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */


	JPanel panel_sup = new JPanel();
	JPanel panel_center = new JPanel();
	JPanel panel_down = new JPanel();
	String[] buttons = {"Mostrar listado de películas", "Mostrar listado de funciones", "Añadir Película", "Eliminar Película", "Crear Función", "Eliminar Función"};
	JButton salir = new JButton("Salir");
	/* Fin declaraciÃ³n */

	public AdminProcesos() {
		/* OrganizaciÃ³n de Layout */
		this.setLayout(new BorderLayout(7, 15));
		panel_sup.setLayout(new BorderLayout(7, 15));
		panel_center.setLayout(new GridLayout(3, 2));
		panel_down.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		//this.setJMenuBar(barra); hay que hacer esto con el JFrame

		panel_sup.add(new JLabel("Opciones de Administrador"), BorderLayout.CENTER);
		this.add(panel_sup, BorderLayout.NORTH);

		for (String i : buttons) {
			panel_center.add(new JButton(i));
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


}
