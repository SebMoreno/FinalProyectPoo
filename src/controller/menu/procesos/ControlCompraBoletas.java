package controller.menu.procesos;

import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.cine.Boleta;
import model.cine.Funcion;
import model.database.Data;
import model.exceptionsapp.DatoNoExistenteException;
import model.user.Cliente;
import model.user.Cuenta;
import view.MenuRegistrado.InformacionPeliculas;
import view.UsuarioAdministrador.ComprarBoleta;

public class ControlCompraBoletas extends ControladorVista implements ActionListener {
	private static int estadoTransaccion;
	private static String cordH;
	private static String cordV;
	private static Funcion f;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		estadoTransaccion++;
		String respuesta = ((JTextField) actionEvent.getSource()).getText();
		switch (estadoTransaccion){
			case 1:
				((ComprarBoleta)ControladorVista.getPantallaActual()).getImpresion().setText(ControladorVista.listadoFunciones());
				((ComprarBoleta)ControladorVista.getPantallaActual()).getTitulo().setText("Lista de Funciones");
				((ComprarBoleta)ControladorVista.getPantallaActual()).getAnswer().setText("Escoja una funcion escribiendo el numero de la funcion:");
				ControladorVista.packActualFrame();
				break;
			case 2:
				try {
					f = new Funcion(respuesta);
				} catch (DatoNoExistenteException e) {
					ControladorVista.getPantallaActual().muestraDatos("La función que eligió no existe\nEl programa se cerrará para evitar conflictos");
					System.exit(0);
				}
				((ComprarBoleta)ControladorVista.getPantallaActual()).getImpresion().setText(f.getSala().toString());
				((ComprarBoleta)ControladorVista.getPantallaActual()).getTitulo().setText("Elección de Silla");
				((ComprarBoleta)ControladorVista.getPantallaActual()).getAnswer().setText("Elija la silla que desee\n" +
						"El significado de las letras es:\n" +
						"P: premium, es decir, vibrosound y preferenciales a la vez\n" +
						"        v: vibrosound\n" +
						"        p: preferenciales\n" +
						"        n: normales\n" +
						"\n" +
						"        Acompañada a esta letra siempre estará o una L(silla libre) o una O(silla ocupada)\n" +
						"\n" +
						"\n" +
						"Ingrese la coordenada vertical");
				ControladorVista.packActualFrame();
				break;
			case 3:
				cordV = respuesta;
				((ComprarBoleta)ControladorVista.getPantallaActual()).getAnswer().setText("Ingrese la coordenada horizontal");
				ControladorVista.packActualFrame();
				break;
			case 4:
				cordH = respuesta;
				int precioBoleta =f.getSala().getPrecio() + f.getSala().getSilla(Integer.parseInt(cordV),Integer.parseInt(cordH)).getIncremento();
				if (((Cliente)ControladorVista.getUsuarioActivo()).getCuenta().getSaldo() >= precioBoleta) {
					new Boleta(((Cliente) ControladorVista.getUsuarioActivo()).getCuenta(), f, f.getSala().getSilla(Integer.parseInt(cordH), Integer.parseInt(cordV)));
					Data.writeTxt("boletas.txt", Boleta.getBoletasList());
					int saldo_nuevo = ((Cliente) ControladorVista.getUsuarioActivo()).getCuenta().getSaldo() - precioBoleta;
					((Cliente) ControladorVista.getUsuarioActivo()).getCuenta().setSaldo(saldo_nuevo);//para cambiar el saldo en la cuenta
					Data.writeTxt("cuentas.txt", Cuenta.getCuentasList());
					short ocupadas = f.getSillasOcupadas();
					ocupadas++;//aumenta las silla ocupadas en la sala
					f.setSillasOcupadas(ocupadas);
					ControladorVista.getPantallaActual().muestraDatos("Su compra fue realizada con éxito");
				}else {
					ControladorVista.getPantallaActual().muestraDatos("Saldo insuficiente");
				}
				estadoTransaccion = 0;
				ControladorVista.setPantallaActual(new InformacionPeliculas());
				ControladorVista.getPantallaActual().muestraDatos("Las_Peliculas_son:\n" + Data.getAllInTxt("peliculas.txt"));
				ControladorVista.getPantallaActual().setController(new ControladorVista[]{new ControlInfoFuncionesYPeliculas()});
				break;
		}
	}
}
