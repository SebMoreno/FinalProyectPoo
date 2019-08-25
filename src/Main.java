
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import view.MenuRegistrado.Informacionfunciones;
import view.VistaPrincipal;

public class Main {
    /* Codigo para crear la barra de usuario y admin, hay que agregarla al JFrame cuando sea necesario
    static JMenuBar barra = new JMenuBar();  //barra para las 3 pantallas de administrador y usuario, ponersela al JFrame
    static JMenu archivo = new JMenu("Archivo");
    static JMenu procesos = new JMenu("Procesos y Consultas");
    static JMenu ayuda = new JMenu("Ayuda");
    */
	public static void main(String[] args) {
		//Data.initModel();
                /*
                barra.add(archivo);
                barra.add(procesos);
                barra.add(ayuda);
                frame.setJMenuBar(barra);
                */
                
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