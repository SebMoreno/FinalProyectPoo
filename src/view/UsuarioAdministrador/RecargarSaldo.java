/**
 * Clase que permite recagar el saldo del usuario regitrado
 *
 * @author Cristian Mejia
 */
package view.UsuarioAdministrador;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.InterfazPanel;

//inicio de la clase
public class RecargarSaldo extends JPanel implements InterfazPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
	private JPanel panel_sup = new JPanel();
	private JPanel panel_center = new JPanel();
	private JPanel panel_center_izq = new JPanel();
	private JPanel panel_center_der = new JPanel();
	private JPanel panel_down = new JPanel();
	private JButton go = new JButton("Ingresar");//boton que usa el usuario cuando ya agrego el dinero necesario
	private JLabel saldo_actual = new JLabel();
	private JLabel ingrese_saldo = new JLabel("Ingrese saldo a recargar");
	public JTextField campo_texto = new JTextField(); //aqui el usuario ingresará el saldo a recargar
	//los eventos se controlarán cuando el usuario presione enter
	/* Fin declaraciÃ³n */

	/**
	 * constructor que agrega al panel los objetos creados anteriormente
	 */
	public RecargarSaldo(int saldo) {
		/* OrganizaciÃ³n de Layout */
		this.setSize(new Dimension(300, 200));
		this.setLayout(new BorderLayout(7, 15));
		panel_sup.setLayout(new BorderLayout(7, 15));
		panel_center.setLayout(new BorderLayout(7, 15));
		panel_center_izq.setLayout(new BorderLayout(7, 15));
		panel_center_der.setLayout(new BorderLayout(7, 15));
		panel_down.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		//campo_texto.setText("Ingrese aqui el saldo a recargar"); //cuando el usuario vaya a escribir se debe borrar
		ingrese_saldo.setText("Su saldo actual es: " + saldo);
		campo_texto.setPreferredSize(new Dimension(100, 25));
		setPreferredSize(new Dimension(300, 200));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_sup.add(saldo_actual, BorderLayout.WEST);
		this.add(panel_sup, BorderLayout.NORTH);

		panel_center_izq.add(ingrese_saldo, BorderLayout.CENTER);
		panel_center.add(panel_center_izq, BorderLayout.WEST);

		panel_center.add(panel_center_der, BorderLayout.EAST);
		panel_center_der.add(campo_texto, BorderLayout.CENTER);
		this.add(panel_center, BorderLayout.CENTER);

		panel_down.add(go, BorderLayout.EAST);
		this.add(panel_down, BorderLayout.SOUTH);
	}

	/**
	 * IMPLEMENTACION METODOS DE LA INTERFAZ
	 */

	/**
	 * Metodo de los controladores
	 * se necesita un controlador para cuando el usuario haga enter
	 *
	 * @param controllers
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
		go.addActionListener((ActionListener) controllers[0]);
	}

	/**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar Debe controlar si tiene la informacion valida o no
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {
		JOptionPane.showMessageDialog(this, textoParaMostrar, "¡Atención!", JOptionPane.WARNING_MESSAGE);
	}

	public JLabel getSaldo_actual() {
		return ingrese_saldo;
	}

	public JTextField getCampo_texto() {
		return campo_texto;
	}
}
