/**
 *clase que contiene la vista de la opcion de menu informacion funciones
* @author: Mariana Betancur
 */
package view.MenuRegistrado;
import java.awt.*;
import java.util.Map;
import javax.swing.*;

public class Informacionfunciones extends JPanel {
    
	/**
         * cosas que contiene el panel
         */
        private JButton go = new JButton("GO");
        private JLabel Descripcion = new JLabel();
        private Choice elegir_pelicula= new Choice();
        private JLabel Titulo = new JLabel();
        private JPanel panel_izq = new JPanel();
        private JPanel panel_der = new JPanel();
	

        /**
         * contructor de la clase , organiza los paneles 
         */
	public Informacionfunciones(){
		
                this.setLayout(new BorderLayout(7,15));
		

		/* Operaciones Adicionales */
                panel_izq.setLayout(new BorderLayout(7,15));
                panel_der.setLayout(new BorderLayout(7,15));
                Titulo.setText("ELIJA SU PELICULA");
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                panel_izq.add(Titulo, BorderLayout.NORTH);
                panel_izq.add(go, BorderLayout.SOUTH);
                
                /**
                 * EL BOTON CHOICE HAY QUE LLENARLO CON LAS PELICULAS A ESCOGER
                 */
                panel_izq.add(elegir_pelicula, BorderLayout.CENTER);
                this.add(panel_izq, BorderLayout.CENTER);
                
                Descripcion.setText("INFORMACIÓN FUNCIONES");
                panel_der.add(Descripcion, BorderLayout.NORTH);
                panel_der.add(new PanelFunciones(), BorderLayout.CENTER);
                this.add(panel_der, BorderLayout.EAST);
		
	}

}
class PanelFunciones extends JPanel{
    
       JPanel auxiliar = new JPanel();

	public PanelFunciones(){
		/**
                 * organizacion de el panel
                 */
                this.setLayout(new BorderLayout(7,15));
                auxiliar.setBackground(Color.WHITE);
                this.add(auxiliar);
                
                /*
                aqui deberia ir lo que contiene el panel
                */
                

	}

	/* Metodos auxiliares */
	/* Fin Metodos auxiliares */

}



