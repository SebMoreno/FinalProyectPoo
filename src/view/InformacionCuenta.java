package view;
import controller.ControladorVista.*;
import model.user.Usuario;
import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.InterfazPanel;

import controller.ControladorVista;
import java.awt.Color;
import javax.swing.JPanel;

public class InformacionCuenta extends JPanel implements InterfazPanel {
    
    
    private JButton go = new JButton("GO");
	
	private JLabel elegir_usuario = new JLabel();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der = new JPanel();
        private JLabel Descripcion = new JLabel("INFORMACION");
        public InformacionCuenta() {

		this.setLayout(new BorderLayout(7, 15));

		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));
		setPreferredSize(new Dimension(400, 400));
		Titulo.setText("USUARIO ACTIVO");
		

		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(go, BorderLayout.SOUTH);

		panel_der.add(Descripcion, BorderLayout.NORTH);

		add(panel_izq, BorderLayout.WEST);
		add(panel_der, BorderLayout.CENTER);
		/* Fin Agregado de Componentes */
	}

	@Override
	public void setController(ControladorVista[] controllers) {

	}

	@Override
	public void muestraDatos(String textoParaMostrar) {

	}
        public class PanelCuenta extends JPanel {

			public JPanel auxiliar;

			PanelCuenta() {
				auxiliar = new JPanel();
				setLayout(new BorderLayout(7, 15));
				auxiliar.setBackground(Color.WHITE);
				add(auxiliar);
				// add(panel_der,BorderLayout.CENTER);
				// TODO llenar el panel con la informacion de las funciones

			}

		}
        
        
        
}
