package view;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import model.ExceptionsApp.NotFillFieldsAdminException;
import model.ExceptionsApp.NotFillFieldsClientException;
import view.UsuarioAdministrador.FieldPanel;

public class Inicio extends JFrame {
	protected JLabel Bienvenida = new JLabel("¡Bienvenido!", SwingConstants.CENTER);
	/**
	 * cosas que contiene el panel
	 */

	private JTextArea Descripcion = new JTextArea("Manual de usuario", 5, 30);
	private JButton fotoAutores = new JButton();
	private JPanel panelIz = new JPanel();// primer contenedor.
	private JPanel panelCenter = new JPanel();// segundo contenedor.
	private JPanel panelBienvenida = new JPanel();
	private JPanel panelFoto = new JPanel();
	private JPanel panelUsuarios = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JScrollPane panelDescripcion = new JScrollPane(Descripcion);
	private JPasswordField campoPass = new JPasswordField();
	private FieldPanel FormularioInicio = new FieldPanel("Ingrese su código de usuario y su clave", new String[]{"Código de Usuario", "Clave"}, "", new String[]{"usuario", "contraseña"}, null);
	private JButton botonAdmin = new SpecialButtonInicio("Administrador");
	private JButton botonCliente = new SpecialButtonInicio("Usuario Común");
	private JButton botonSalir = new SpecialButtonInicio("Salir del programa");

	/**
	 * contructor de la clase , organiza los paneles
	 */
	public Inicio() {
		super("CinExceso");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 200);


		setLayout(new BorderLayout(10, 10));
		panelIz.setLayout(new BorderLayout(10, 10));
		panelCenter.setLayout(new BorderLayout(10, 10));
		panelBienvenida.setLayout(new BorderLayout());
		panelFoto.setLayout(new BorderLayout());
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panelUsuarios.setLayout(new BorderLayout(10, 10));

		Descripcion.setLineWrap(true);
		Descripcion.setEditable(false);
		JPanel aux = (JPanel) FormularioInicio.getComponent(1);
		aux.remove(3);
		aux.add(campoPass);
		fotoAutores.setBorder(null);
		fotoAutores.setSize(638, 638);
		fotoAutores.setContentAreaFilled(false);
		fotoAutores.setIcon(new ImageIcon(new ImageIcon("temp\\1.gif").getImage().getScaledInstance(fotoAutores.getWidth(), fotoAutores.getHeight(), Image.SCALE_DEFAULT)));

		panelBienvenida.add(Bienvenida, BorderLayout.CENTER);
		panelFoto.add(fotoAutores, BorderLayout.CENTER);
		panelIz.add(panelBienvenida, BorderLayout.CENTER);
		panelIz.add(panelFoto, BorderLayout.SOUTH);

		panelBotones.add(botonAdmin);
		panelBotones.add(botonCliente);
		panelUsuarios.add(panelBotones, BorderLayout.NORTH);
		panelUsuarios.add(botonSalir, BorderLayout.SOUTH);
		panelCenter.add(panelDescripcion, BorderLayout.NORTH);
		panelCenter.add(panelUsuarios, BorderLayout.CENTER);

		add(panelIz, BorderLayout.WEST);
		add(panelCenter, BorderLayout.CENTER);
	}


	public void run() {
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}

	public InterfazBotonInicio getBotonSalir() {
		return (InterfazBotonInicio) botonSalir;
	}

	public class SpecialButtonInicio extends JButton implements InterfazBotonInicio {
		int Salir = -1;
		boolean isAdminEntering;

		SpecialButtonInicio(String texto) {
			super(texto);
		}

		public void muestraDatos(String textoParaMostrar) {
			if (JOptionPane.showConfirmDialog(Inicio.this, textoParaMostrar, "Salir del Programa", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
				Salir = InterfazPanel.Salir;
			}
		}

		public void setController(ControladorVista[] controllers) {
			Bienvenida.addMouseListener((MouseListener) controllers[0]);
			fotoAutores.addActionListener((ActionListener) controllers[1]);
			botonAdmin.addActionListener((ActionListener) controllers[2]);
			botonCliente.addActionListener((ActionListener) controllers[3]);
			botonSalir.addActionListener((ActionListener) controllers[4]);
		}

		public void apareceFormulario() {
			panelUsuarios.add(FormularioInicio, BorderLayout.CENTER);
		}

		public void packInicio() {
			pack();
		}

		public void isAdminEntering(boolean isIt) {
			if (isIt) {
				botonAdmin.setText("Administrador | Complete y Nuevamente Clic");
				botonCliente.setText("Usuario Común");
				isAdminEntering = true;
			} else {
				botonAdmin.setText("Administrador");
				botonCliente.setText("Usuario Común | Complete y Nuevamente Clic");
				isAdminEntering = false;
			}

		}

		public int quiereSalir() {
			return Salir;
		}

		public String getUsuario() throws NotFillFieldsAdminException, NotFillFieldsClientException {
			String aux = FormularioInicio.getValue("Código de Usuario");
			return isCampoLleno(aux);
		}

		public String getClave() throws NotFillFieldsAdminException, NotFillFieldsClientException {
			String aux = FormularioInicio.getValue("Clave");
			return isCampoLleno(aux);
		}

		public void mostrarError(String error, String titulo, int icono) {
			JOptionPane.showMessageDialog(Inicio.this, error, titulo, icono);
		}

		private String isCampoLleno(String campo) throws NotFillFieldsAdminException, NotFillFieldsClientException {
			if (campo.equals("")) {
				if (isAdminEntering) {
					throw new NotFillFieldsAdminException();
				} else {
					throw new NotFillFieldsClientException();
				}
			} else {
				return campo;
			}
		}
	}

}
