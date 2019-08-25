package view;

import javax.swing.*;

import controller.ControladorVista;

import java.awt.*;

public class Inicio extends JFrame implements InterfazPanel {
	JButton button1 = new JButton("Haga clic para ver fotos de los autores del sistema");
	// button1.setMaximumSize(new Dimension(200,100));
	// botonPrueba2.setMinimumSize(new Dimension(20,20));
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	Container container;

	public Inicio() {
		super("Cine X");
		JPanel panel1 = new JPanel();// primer contenedor.
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();// segundo contenedor.
		JPanel panel5 = new JPanel();
		// JPanel panel6 = new JPanel();
		JScrollPane panelgamma = new JScrollPane(new JTextArea("Manueal de usuario"));

		container = this.getContentPane();
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
		// todo panel FIELD de cristo

		container.setLayout(new BorderLayout(10, 10));
		container.add(panel1, BorderLayout.WEST);
		container.add(panel4, BorderLayout.EAST);
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void setController(ControladorVista[] controllers) {
		// todo hacer lso metodos
	}

	public void muestraDatos(String textoParaMostrar) {
		// todo hacer metodos
	}
}
