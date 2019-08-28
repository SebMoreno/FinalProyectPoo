package view.MenuRegistrado;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.user.Usuario;
import view.InterfazPanel;

public class InformacionCuenta extends JPanel implements InterfazPanel {


	private JButton go = new JButton("Muestrame mis datos!");

	private JLabel elegir_usuario = new JLabel();
	private JLabel Titulo = new JLabel();
	Usuario activo = ControladorVista.getUsuarioActivo();
	private JPanel panel_izq = new JPanel();
	private JPanel panel_der = new JPanel();
	private JLabel Descripcion = new JLabel("                        INFORMACION");

	public InformacionCuenta() {

		setLayout(new BorderLayout(7, 15));

		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		panel_der.setLayout(new BorderLayout(7, 15));
		setPreferredSize(new Dimension(400, 400));
		Titulo.setText("USUARIO ACTIVO: " + activo.getUsuario());


		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.CENTER);
		panel_izq.add(go, BorderLayout.SOUTH);

		panel_der.add(Descripcion, BorderLayout.NORTH);

		add(panel_izq, BorderLayout.WEST);
		add(panel_der, BorderLayout.CENTER);
		/* Fin Agregado de Componentes */
	}

	@Override
	public void setController(ControladorVista[] controllers) {
		go.addActionListener((ActionListener) controllers[0]);

	}

	@Override
	public void muestraDatos(String textoParaMostrar) {

		String[] infousuario = textoParaMostrar.split(" ");
		JTextArea funcio = new JTextArea();
		JScrollPane panelDescripcion = new JScrollPane(funcio);
		funcio.append("User " + infousuario[0] + "\nSaldo " + infousuario[1]);
		if (panel_der.getComponents().length == 2) {
			panel_der.remove(1);
		}
		panel_der.add(panelDescripcion, BorderLayout.CENTER);

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
