import controller.ControladorVista;
import model.database.Data;
import view.Inicio;

public class Main {
	public static void main(String[] args) {

		//TODO Centrar la ventana inicial y borrar el texto usuario en el primer textField

		//Data.initModel();
		/*
		VistaPrincipal s = new VistaPrincipal("Yo", new String[]{"Chupame", "La", "Verga"}, new Inicio());
		s.run();

		 */
		/*
		Iniciar modelo
		Iniciar controllers
		Iniciar vista

		Run
		 */
		Data.readAllTxt();
		Inicio i = new Inicio();
		ControladorVista.setControladoresVistaInicial(i.getBotonSalir());
		i.run();


	}
}

/**
 * TODO falta 1 funcionalidad
 * 3 exepciones nuevas : pelicula erronea , funcion erronea , saldo insuficiente
 * Tener en cuenta: Constructor de Bienvenida new Bienvenida("temp\\fondo.gif");
 */
