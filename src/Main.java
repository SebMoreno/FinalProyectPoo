import controller.ControladorInicio;
import model.database.Data;
import view.Inicio;

public class Main {
	public static void main(String[] args) {
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
		ControladorInicio.setControladoresVistaInicial(i.getBotonSalir());
		i.run();


	}
}