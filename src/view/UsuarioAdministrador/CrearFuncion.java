/**
 * Vista de la opcion de menu que permite al administrador crear funciones
 *
 * @author Mariana Betancur Florez
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
import view.InterfazPanel;

public class CrearFuncion extends JPanel implements InterfazPanel {
	/* Empieza declaracion de subobjetos pertenencientes a este objeto principal */
	private JLabel ingrese_datos = new JLabel("Ingresar datos para una nueva funcion");
	private String datos = "Datos";
	private String valor = "Valor";
	private String[] lista_datos = {"Codigo de la funcion", "Sala", "Titulo pelicula", "Hora", "Sillas ocupadas"};
	private JPanel panel_sup = new JPanel();
	private FieldPanel panel_center;
	private JPanel panel_down = new JPanel();
	private JButton boton = new JButton("Ingresar Datos");
	/* Fin declaracion */
	public FieldPanel getFieldPanel() {
		return panel_center;
	}
	/**
	 * Constructor de la clase agrega los objetos mencionados anteriormente al constructor
	 */
	public CrearFuncion() {
		setPreferredSize(new Dimension(400, 300));
		/* OrganizaciÃ³n de Layout */
		this.setLayout(new BorderLayout(7, 15));
		panel_sup.setLayout(new BorderLayout(7, 15));
		panel_down.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Agregado de Componentes */
		panel_sup.add(ingrese_datos, BorderLayout.CENTER);
		this.add(panel_sup, BorderLayout.NORTH);

		panel_center = new FieldPanel(datos, lista_datos, valor, new String[]{"codigo creado automáticamente", "","","","0"}, new boolean[]{false, true, true, true, false});
		this.add(panel_center, BorderLayout.CENTER);

		panel_down.add(boton, BorderLayout.CENTER);
		this.add(panel_down, BorderLayout.SOUTH);
		/* Fin Agregado de Componentes */


	}

	/**
	 * inicio implementacion metodos de la interfaz
	 */

	/**
	 * Metodo de los controladores
	 *
	 * @param controllers TODO hay que programar el controlador boton que summit la informacion rellenada en lo campos anteriores y crea una funcion o activa el mensaje de error
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
		boton.addActionListener((ActionListener) controllers[0]);
	}

	/**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar TODO se tiene que verificar que la informacion suminisrada sea valida para ver cual option pane agregar
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {
		if (textoParaMostrar.equals("Funcion creada con éxito")){
			JOptionPane.showMessageDialog(this, textoParaMostrar, "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, textoParaMostrar, "Oh no..", JOptionPane.WARNING_MESSAGE);
		}
	}


}