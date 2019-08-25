package view.UsuarioAdministrador;

import javax.swing.*;
import java.awt.*;

public class PanelAñadirPelicula extends JPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
        private JLabel ingrese_datos = new JLabel("Ingrese los siguientes datos");
        private String datos = "Datos";
        private String valor = "Valor";
        private String [] lista_datos = {"Nombre de la Película","Género","Clasificación","Duración","Idioma"};
        private JPanel panel_sup = new JPanel();
        private JPanel panel_center = new JPanel();
        private JPanel panel_down = new JPanel();
        private JButton boton = new JButton("Ingresar Datos");
	/* Fin declaraciÃ³n */

	public PanelAñadirPelicula(){
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new BorderLayout(7,15));
                panel_sup.setLayout(new BorderLayout(7,15));
                panel_down.setLayout(new BorderLayout(7,15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                panel_sup.add(ingrese_datos, BorderLayout.CENTER);
                this.add(panel_sup, BorderLayout.NORTH);
                
                FieldPanel panelField = new FieldPanel(datos, lista_datos, valor, null);
                panel_center = panelField;
                this.add(panel_center, BorderLayout.CENTER);
                
                panel_down.add(boton, BorderLayout.CENTER);
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