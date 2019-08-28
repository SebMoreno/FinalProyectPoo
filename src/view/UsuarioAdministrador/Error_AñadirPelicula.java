package view.UsuarioAdministrador;

public class Error_AñadirPelicula extends JPanel {
//Este panel aparecerá cuando se ingrese una pelicula ya ingresada en AñadirPelicula

	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
	private JLabel problem1 = new JLabel("                                      Película ya ingresada");
	private JLabel problem2 = new JLabel("                                 Ingrese una película distinta");
	private JPanel panel_sup = new JPanel();
	private JPanel panel_center = new JPanel();
	private JPanel panel_down = new JPanel();
	private JPanel panel_east = new JPanel();
	private JPanel panel_west = new JPanel();
	private JButton aceptar = new JButton("aceptar");
	/* Fin declaraciÃ³n */

	public Error_AñadirPelicula() {
		/* OrganizaciÃ³n de Layout */
		this.setLayout(new BorderLayout(7, 15));
		panel_center.setLayout(new BorderLayout(7, 15));
		panel_sup.setLayout(new BorderLayout(7, 15));
		panel_down.setLayout(new BorderLayout(7, 15));
		/* Fin Layout */

		/* Operaciones Adicionales */
		setPreferredSize(new Dimension(600, 800));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		this.add(panel_sup, BorderLayout.NORTH);

		panel_center.add(problem1, BorderLayout.NORTH);
		panel_center.add(problem2, BorderLayout.CENTER);
		this.add(panel_center, BorderLayout.CENTER);

		panel_down.add(aceptar, BorderLayout.CENTER);
		this.add(panel_down, BorderLayout.SOUTH);

		this.add(panel_west, BorderLayout.WEST);
		this.add(panel_east, BorderLayout.EAST);
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
