/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UsuarioAdministrador;

/**
 * @author Cristianm120
 */

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.InterfazPanel;

public class CambiarContraseña extends JPanel implements InterfazPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
	JPanel panel_sup = new JPanel();
	JPanel panel_center;
	JPanel panel_down = new JPanel();
	String titulo = " ";
	String[] titulos = {"Ingrese su actual contraseña", "Ingrese su nueva contraseña", "Ingrese su nueva contraseña nuevamente"};
	String valores = " ";
	JLabel cambio = new JLabel("CAMBIO DE CONTRASEÑA");
	JButton boton = new JButton("Ingresar");
	/* Fin declaraciÃ³n */

	public CambiarContraseña() {
		/* OrganizaciÃ³n de Layout */
		this.setLayout(new BorderLayout(7, 15));
		panel_sup.setLayout(new BorderLayout(7, 15));
		panel_down.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_sup.add(cambio, BorderLayout.CENTER);
		this.add(panel_sup, BorderLayout.NORTH);

		FieldPanel panel = new FieldPanel(titulo, titulos, valores, null, null);
		panel_center = panel;
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

	@Override
	public void setController(ControladorVista[] controllers) {
		boton.addActionListener((ActionListener) controllers[0]);
	}

	@Override
	public void muestraDatos(String textoParaMostrar) {

	}


}

