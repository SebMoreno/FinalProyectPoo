package view.UsuarioAdministrador;

import javax.swing.*;
import java.awt.*;

public class PanelComprarBoleta extends JPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
        public JTextField entrada = new JTextField(); // sera el campo de texto donde el usuario ingrese lo solicitado
        //los eventos se controlarán cuando el usuario presione enter
        private JLabel answer = new JLabel("Ingrese su Respuesta"); // Este label debe decir que debe ingresar el usuario
        public JLabel Titulo = new JLabel(); // este label dira la información de que se esta mostrando, es decir, se muestran las peliculas, las funciones, y las sillas
        private JPanel panel_izq = new JPanel();
        private JPanel panel_der_center = new JPanel();
        private JPanel panel_der = new JPanel();
	/* Fin declaraciÃ³n */

	public PanelComprarBoleta(){
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new BorderLayout(7,15));
		/* Fin Layout */

		/* Operaciones Adicionales */
                panel_izq.setLayout(new BorderLayout(7,15));
                panel_der_center.setLayout(new BorderLayout(7,15));
                panel_der.setLayout(new BorderLayout(7,15));
                Titulo.setText("Titulo");
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

class PanelTexto extends JPanel{
    /* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
        JTextArea impresion = new JTextArea();
        JScrollPane scroll = new JScrollPane(); //scroll para el textArea
	/* Fin declaraciÃ³n */

	public PanelTexto(){
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new BorderLayout(0,0));
		/* Fin Layout */

		/* Operaciones Adicionales */
                impresion.setEditable(false); // para que el usuario no pueda ingresar texto
                scroll.setViewportView(impresion); //añadir el scroll al textArea
                impresion.append("Ejemplo Texto"); // aqui debe ir la informacion que hay que mostrar, es decir, las peliculas disponibles, las sillas disponibles y las funciones existentes.
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                this.add(impresion, BorderLayout.CENTER);
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
