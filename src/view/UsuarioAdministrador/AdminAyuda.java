package view.UsuarioAdministrador;

import javax.swing.*;
import java.awt.*;

public class AdminAyuda extends JPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
        JLabel titulo = new JLabel("Autores");
        String [] autores = {"Mariana Betancur Florez", "Jairo Cortés Roncancio", "Juan Sebastián Moreno Ruiz", "Cristian Mejía Martínez"};
        JButton salir = new JButton("Salir");
        JPanel panel_sup = new JPanel();
        JPanel panel_center = new JPanel();
        JPanel panel_down = new JPanel();
	/* Fin declaraciÃ³n */

	public AdminAyuda(){
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new BorderLayout(7,15));
                panel_sup.setLayout(new BorderLayout(7,15));
                panel_center.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
                panel_down.setLayout(new BorderLayout(7,15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                panel_sup.add(titulo, BorderLayout.CENTER);
                this.add(panel_sup, BorderLayout.NORTH);
                
                for (String i:autores){
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


}
