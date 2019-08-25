package view;

import javax.swing.*;

import controller.ControladorVista;

import java.awt.*;

public class Inicio extends JFrame implements InterfazPanel {
	/**
	 * cosas que contiene el panel
	 */

	private JButton button1 = new JButton("Haga clic para ver fotos de los autores del sistema");
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JButton button4 = new JButton();

	private JPanel panel1 = new JPanel();// primer contenedor.
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();// segundo contenedor.
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	/**
	 * contructor de la clase , organiza los paneles
	 */
	public Inicio(int sizeVertical, int sizeHorizontal) {
		super("Cine X");
		setSize(sizeVertical, sizeHorizontal);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JScrollPane panelgamma = new JScrollPane(new JTextArea("Manueal de usuario"));

		panel1.setLayout(new BorderLayout(10, 10));
		panel1.add(panel2, BorderLayout.WEST);
		panel2.add(panel3);
		panel1.add(panel4, BorderLayout.CENTER);
		panel4.add(panel5);
		// panel4.add(panel6);

		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(button1);

		panel3.setLayout(new GridLayout(1, 1));
		// panel3.setBackground(Color.GREEN);
		panel3.add(new JLabel("Bienvenido"));
		button1.setSize(50000, 500);

		panel4.setLayout(new GridLayout(2, 1));

		panel5.setLayout(new BorderLayout(10, 10));
		panel5.add(panelgamma, BorderLayout.CENTER);
		// TODO panel FIELD de cristo poner los otros tres botones

		getContentPane().setLayout(new BorderLayout(10, 10));
		add(panel1, BorderLayout.WEST);
		add(panel4, BorderLayout.EAST);
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
