
package view.UsuarioAdministrador;


import javax.swing.*;
import java.awt.*;

public class EliminarPelicula extends JPanel {
	/**
         * cosas que contiene el panel
         */
        private JButton go = new JButton("Eliminar");
        private Choice elegir_pelicula= new Choice();
        private JLabel Titulo = new JLabel();
        private JPanel panel_izq = new JPanel();
        
	
        /**
         * constructor que agrega todas las cosas al panel 
         */
	public EliminarPelicula(){
		
                this.setLayout(new BorderLayout(7,15));
		/* Operaciones Adicionales */
                panel_izq.setLayout(new BorderLayout(7,15));
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