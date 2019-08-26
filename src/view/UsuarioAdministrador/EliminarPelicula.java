package view.UsuarioAdministrador;


import java.awt.BorderLayout;
import java.awt.Choice;
import controller.ControladorVista;
import java.awt.event.ActionListener;
import view.InterfazPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EliminarPelicula extends JPanel implements InterfazPanel {
	/**
	 * cosas que contiene el panel
	 */
	private JButton go = new JButton("Eliminar");
	private Choice elegir_pelicula = new Choice();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();


	/**
	 * constructor que agrega todas las cosas al panel
	 */
	public EliminarPelicula() {

		this.setLayout(new BorderLayout(7, 15));
		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
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
         /**
         * inicio implementacion metodos de la interfaz
         */
        
        /**
	 * Metodo de los controladores
	 *
	 * @param controllers 
         * BOTON QUE ACTIVA EL BORRADO
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
		go.addActionListener((ActionListener) controllers[0]);
	}
        
        /**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar
         * TODO se tiene que verificar que la informacion suminisrada sea valida para ver cual option pane agregar
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {
             //en caso de exito
            JOptionPane.showMessageDialog(go,textoParaMostrar);
		
	}
        
        
        
        
        

}