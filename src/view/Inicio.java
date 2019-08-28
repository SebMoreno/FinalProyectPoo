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
	private JTextArea Descripcion = new JTextArea("Bienvenido a CINEXCESO\n" +
			"\n" +
			"En este apartado encontraras el manual de usuario. Lee con detenimiento las siguientes instrucciones y podrás disfrutar esta aplicación al máximo, recuerde que este sistema es traído a sus manos por:\n" +
			"Mariana Betancur, Cristian Mejia, Sebastian Moreno y Jairo Andres Cortez.\n" +
			"Comencemos:\n" +
			"1.\tEn este momento se encuentra en la ventana principal de inicio aquí podrá seleccionar su tipo de usuario, sea ADMINISTRADOR O USUARIO COMUN.\n" +
			"\n" +
			"Si pasa el mouse por el recuadro de bienvenida podrá ver como la letra cambia de color a azul únicamente cuando el mouse este sobre ella\n" +
			"\n" +
			"El botón que dice “Haga click para ver los autores del sistema” cuando haga click sobre el boton (oprimir con el mouse) se mostrara foto de los autores del sistema, lo mismo para el segundo click , la tercera vez volverá a aparecer el botón mencionado anteriormente.\n" +
			"\n" +
			"Además al escoger su tipo de usuario en la parte de debajo de este recuadro (ojo no al interior) deberá llenar los datos correspondientes NO PUEDE AVANZAR EN SU INTERRACION CON EL PROGRAMA SI NO LO HACE \n" +
			"\n" +
			"2.\tLuego de hacer lo planteado anteriormente se desplegará una nueva vista DEPENDIENDO DEL USUARIO ELEGIDO ANTERIORMENTE, hay una ventana que le advierte si se quiere salir, es su decisión si lo quiere hacer.\n" +
			"Antes de proseguir se dividirán LAS FUNCIONALIDADES DEL SISTEMA POR TIPO DE USUARIO, LEA MUY BIEN LAS SIGUIENTES LISTAS PARA SABER QUE PUEDE REALIZAR CON ESTE SISTEMA:\n" +
			"\n" +
			"USUARIO COMUN: INFORMACION PELICULAS, INFORMACION FUNCIONES, RECARGAR SALDO, COMPRAR BOLETA, INFORMACION CUENTA.\n" +
			"\n" +
			"ADMINISTRADOR: INFORMACION PELICULAS, INFORMACION FUNCIONES, ANADIR FUNCIONES, ANADIR PELICULAS, ELIMINAR PELICULAS.\n" +
			"\n" +
			"Ahora se procederá a explicar cada vista, se comenzará con USUARIO COMUN\n" +
			"\n" +
			"•\tEn la parte superior de la ventana aparece el nombre del usuario que este activo en ese momento, en este caso aparecerá su nombre \n" +
			"•\tHay tres apartados en su menú \n" +
			"ARCHIVO: podrá ver su información tal como su nombre , cedula , saldo , boletas compradas .\n" +
			"PROCESOS Y CONSULTAS: aparecen las consultas que puede tener este usuario. PARA MAYOR ENTENDIMIENTO SE VOLVERAN A LISTAR A CONTINUACION INFORMACION PELICULAS, INFORMACION FUNCIONES, RECARGAR SALDO, COMPRAR BOLETA.\n" +
			"\n" +
			"AYUDA: nombre de los autores de la aplicación mencionados en el inicio \n" +
			"•\tDependiendo de la opción que hubiese elegido se mostrara en esa misma vista lo que puede hacer en la opción elegida\n" +
			"•\tLos resultados de la consulta se mostrarán en la parte inferior de la pantalla.\n" +
			"\n" +
			"Se hará una descripción de cada opción de menú (DEL USUARIO COMUN) a continuación:\n" +
			"\n" +
			"-INFORMACION PELICULAS: se desplegará una ventana con la información de todas las películas existentes en nuestro sistema con la siguiente información: TITULO, GENERO, IDIOMA, CLASIFICACION y DURACION no necesariamente en ese orden.\n" +
			"\n" +
			"-INFORMACION FUNCIONES: lo primero que tiene que hacer es escoger la película de la cual quiere saber la información de las funciones disponibles en nuestro sistema con la siguiente información: SALA, SILLAS DISPONIBLE, ID DE LA FUNCION, HORA, PELICULA no necesariamente en ese orden.\n" +
			"\n" +
			"-RECARGAR SALDO: permite recargar el saldo ya presente en la cuenta, antes te muestra el saldo actual \n" +
			"\n" +
			"                             -COMPRAR BOLETA: permite comprar boleta de la película y la función seleccionada\n" +
			"Ahora se describirá ADMINISTRADOR:\n" +
			"•\tEn la parte superior de la ventana aparece el nombre del usuario que este activo en ese momento, en este caso aparecerá su nombre \n" +
			"•\tHay tres apartados en su menú\n" +
			"ARCHIVO: podrá ver su información tal como su nombre , saldo , boletas compradas .\n" +
			"              PROCESOS Y CONSULTAS: aparecen las consultas que puede tener este usuario. PARA MAYOR \n" +
			"              ENTENDIMIENTO\n" +
			"AYUDA: nombre de los autores de la aplicación mencionados en el inicio INFORMACION PELICULAS, INFORMACION FUNCIONES, ANADIR FUNCIONES, ANADIR PELICULAS, ELIMINAR PELICULAS.\n" +
			"\n" +
			"•\tDependiendo de la opción que hubiese elegido se mostrara en esa misma vista lo que puede hacer en la opción elegida\n" +
			"•\tLos resultados de la consulta se mostrarán en la parte inferior de la pantalla.\n" +
			"\n" +
			"Se hará una descripción de cada opción de menú (DEL USUARIO COMUN) a continuación:\n" +
			"\n" +
			"-INFORMACION PELICULAS: se desplegará una ventana con la información de todas las películas existentes en nuestro sistema con la siguiente información: TITULO, GENERO, IDIOMA, CLASIFICACION y DURACION no necesariamente en ese orden.\n" +
			"\n" +
			"-INFORMACION FUNCIONES: lo primero que tiene que hacer es escoger la película de la cual quiere saber la información de las funciones disponibles en nuestro sistema con la siguiente información: SALA, SILLAS DISPONIBLE, ID DE LA FUNCION, HORA, PELICULA no necesariamente en ese orden.\n" +
			"\n" +
			"-ELIMINAR PELICULAS: escoja en el apartado la película que desea y hunda el botón eliminar.\n" +
			"\n" +
			"-ANADIR PELICULAS: pide la información correspondiente de una película en nuestro sistema: TITULO, GENERO, IDIOMA, CLASIFICACION y DURACION no necesariamente en ese orden.\n" +
			"\n" +
			"-ANADIR FUNCIONES: pide la información correspondiente de una FUNCIONES en nuestro sistema: SALA, SILLAS DISPONIBLE, ID DE LA FUNCION, HORA, PELICULA.\n" +
			"\n" +
			"Ahora tiene la información necesaria para manejar nuestra aplicación de manera correcta,DISFRUTE!\n" +
			"\n" +
			"\n" +
			"\n", 5, 30);
	private JButton fotoAutores = new JButton();
	private JPanel panelIz = new JPanel();// primer contenedor.
	private JPanel panelCenter = new JPanel();// segundo contenedor.
	private JPanel panelBienvenida = new JPanel();
	private JPanel panelFoto = new JPanel();
	private JPanel panelUsuarios = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JScrollPane panelDescripcion = new JScrollPane(Descripcion);
	private JPasswordField campoPass = new JPasswordField();
	private FieldPanel FormularioInicio = new FieldPanel("Ingrese su código de usuario y su clave", new String[]{"Código de Usuario", "Clave"}, "", new String[]{"", "contraseña"}, null);
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
		FormularioInicio.getTextFields().remove(1);
		FormularioInicio.getTextFields().add(campoPass);
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

		public JFrame getActualFrame() {
			return Inicio.this;
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
