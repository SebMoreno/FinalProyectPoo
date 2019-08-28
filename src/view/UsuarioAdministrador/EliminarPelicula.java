package view.UsuarioAdministrador;

public class EliminarPelicula extends JPanel implements InterfazPanel {
	/**
	 * cosas que contiene el panel
	 */
	private JButton go = new JButton("Eliminar");
	private JComboBox elegir_pelicula = new JComboBox();
	private JLabel Titulo = new JLabel();
	private JPanel panel_izq = new JPanel();
	private final static HashMap<String, String[]> pelisList = new HashMap<>();

	/**
	 * constructor que agrega todas las cosas al panel
	 */
	public EliminarPelicula() {

		this.setLayout(new BorderLayout(7, 15));
		/* Operaciones Adicionales */
		panel_izq.setLayout(new BorderLayout(7, 15));
		Titulo.setText("                           ELIJA SU PELICULA");
		setPreferredSize(new Dimension(600, 800));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
		panel_izq.add(Titulo, BorderLayout.NORTH);
		panel_izq.add(go, BorderLayout.SOUTH);
		/**
		 * peliculas añadidas
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
	 * @param controllers BOTON QUE ACTIVA EL BORRADO
	 */
	@Override
	public void setController(ControladorVista[] controllers) {
		go.addActionListener((ActionListener) controllers[0]);
	}

	/**
	 * METODO QUE MUESTRA TODA LA INFORMACION NECESARIA
	 *
	 * @param textoParaMostrar TODO se tiene que verificar que la informacion suminisrada sea valida para ver cual option pane agregar
	 */
	@Override
	public void muestraDatos(String textoParaMostrar) {
		String[] datos = textoParaMostrar.split("\n");
		if (datos[0] == "pelicula") {
			for (int i = 0; i < datos.length; i++) {
				String DatosCompletos = datos[0];
				String data[] = DatosCompletos.split(" ");
				elegir_pelicula.addItem(data[0]);

			}

		} else {

			JOptionPane.showMessageDialog(go, textoParaMostrar);

		}


	}
}