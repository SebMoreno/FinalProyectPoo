import view.MenuRegistrado.Informacionfunciones;
import view.VistaPrincipal;

public class Main {
	public static void main(String[] args) {
		//Data.initModel();
		VistaPrincipal s = new VistaPrincipal("Yo", new String[]{"Chupame", "La", "Verga"}, new Informacionfunciones());
		s.run();
		/*
		Iniciar modelo
		Iniciar controllers
		Iniciar vista

		Run
		 */
	}
}
