package view.UsuarioAdministrador;

import java.awt.*;
import javax.swing.*;

public class RecargarSaldo extends JPanel{
    /* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
        private JPanel panel_sup = new JPanel();
        private JPanel panel_center = new JPanel();
        private JPanel panel_center_izq = new JPanel();
        private JPanel panel_center_der = new JPanel();
        private JLabel saldo_actual = new JLabel("Su saldo actual es: ");
        private JLabel saldo = new JLabel("0"); //aqui hay que poner el saldo actual del cliente
        private JLabel ingrese_saldo = new JLabel("Ingrese saldo a recargar");
        private JLabel exito = new JLabel("¡Su saldo se ha recargado con éxito!"); //Este mensaje solo debe salir cuando se active el evento
        private JTextField saldo_a_recargar = new JTextField(); //aqui el usuario ingresará el saldo a recargar
        //los eventos se controlarán cuando el usuario presione enter
	/* Fin declaraciÃ³n */

	public RecargarSaldo(){
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new BorderLayout(7,15));
                panel_sup.setLayout(new BorderLayout(7,15));
                panel_center.setLayout(new BorderLayout(7,15));
                panel_center_izq.setLayout(new BorderLayout(7,15));
                panel_center_der.setLayout(new BorderLayout(7,15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                panel_sup.add(saldo_actual, BorderLayout.WEST);
                panel_sup.add(saldo, BorderLayout.CENTER);
                this.add(panel_sup, BorderLayout.NORTH);
                
                panel_center_izq.add(ingrese_saldo, BorderLayout.CENTER);
                panel_center.add(panel_center_izq, BorderLayout.WEST);
                
                panel_center_der.add(saldo_a_recargar, BorderLayout.CENTER);
                panel_center_der.add(exito, BorderLayout.SOUTH);
                panel_center.add(panel_center_der, BorderLayout.EAST);
                this.add(panel_center, BorderLayout.CENTER);
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
