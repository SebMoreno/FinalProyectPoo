package view;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import view.UsuarioAdministrador.FieldPanel;

public class Inicio extends JFrame implements InterfazPanel {
	protected JLabel Bienvenida = new JLabel("¡Bienvenido!", SwingConstants.CENTER);
	/**
	 * cosas que contiene el panel
	 */
	private JTextArea Descripcion = new JTextArea("Manual de usuario", 5, 30);
	private JButton FotoAutores = new JButton();
	private JButton botonAdmin = new JButton("Administrador");
	private JButton botonCliente = new JButton("Usuario Común");

	private JPanel panelIz = new JPanel();// primer contenedor.
	private JPanel panelCenter = new JPanel();// segundo contenedor.
	private JPanel panelBienvenida = new JPanel();
	private JPanel panelFoto = new JPanel();
	private JPanel panelUsuarios = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JScrollPane panelDescripcion = new JScrollPane(Descripcion);
	private JPasswordField campoPass = new JPasswordField();
	private FieldPanel FormularioInicio = new FieldPanel("Ingrese su código de usuario y su clave", new String[]{"Código de Usuario", "Clave"}, "", new String[]{"usuario", "contraseña"}, null);

	/**
	 * contructor de la clase , organiza los paneles
	 */
	public Inicio() {
		super("Cine X");
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
		JPanel aux = (JPanel) FormularioInicio.getComponent(1);
		aux.remove(3);
		aux.add(campoPass);
		FotoAutores.setBorder(null);
		FotoAutores.setSize(638, 638);
		FotoAutores.setContentAreaFilled(false);
		FotoAutores.setIcon(new ImageIcon(new ImageIcon("temp\\1.gif").getImage().getScaledInstance(FotoAutores.getWidth(), FotoAutores.getHeight(), Image.SCALE_DEFAULT)));

		panelBienvenida.add(Bienvenida, BorderLayout.CENTER);
		panelFoto.add(FotoAutores, BorderLayout.CENTER);
		panelIz.add(panelBienvenida, BorderLayout.CENTER);
		panelIz.add(panelFoto, BorderLayout.SOUTH);

		panelBotones.add(botonAdmin);
		panelBotones.add(botonCliente);
		panelUsuarios.add(panelBotones, BorderLayout.NORTH);
		panelUsuarios.add(FormularioInicio, BorderLayout.CENTER);
		panelCenter.add(panelDescripcion, BorderLayout.NORTH);
		panelCenter.add(panelUsuarios, BorderLayout.CENTER);

		add(panelIz, BorderLayout.WEST);
		add(panelCenter, BorderLayout.CENTER);
	}

	public void setController(ControladorVista[] controllers) {
		// TODO hacer metodo
	}

	public void muestraDatos(String textoParaMostrar) {
		// TODO hacer metodo
	}

	public void run() {
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}


}
