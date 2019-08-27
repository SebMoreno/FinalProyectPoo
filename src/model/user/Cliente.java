package model.user;

//clase que genera objetos tipo cliente heredada de usuarios
//ESTRUCTURAS: estan en la clase padre

import java.io.IOException;
import model.ExceptionsApp.WrongCredentialsException;

public class Cliente extends Usuario {

	private static String[] capacidades = {"Listado de Películas", "Listado de Funciones", "Comprar Boleta", "Mostrar la Información de mi cuenta", "Recargar Saldo"};
	private final Cuenta cuenta;

	public Cliente(String usuario, String clave) throws WrongCredentialsException, IOException {
		super(usuario, clave, "cliente");
		this.cuenta = new Cuenta(this, true);
	}

	public Cliente(String usuario, String clave, String nombre) {
		this(usuario, clave, nombre, "NE", false);
	}

	public Cliente(String usuario, String clave, String nombre, String email, boolean existe) {//hay un boolean existe que es el que ayuda a crear objetos de ese tipo que no se quieren guardar en el txt(ya que solo se necesitan para llamar metodos y/o atributos
		super(usuario, clave, "cliente", nombre, email, existe);
		this.cuenta = new Cuenta(this, existe);
	}

	public Cuenta getCuenta() {
		return cuenta;
	}


	public static java.lang.String[] getCapacidades() {
		return capacidades;
	}

	public static void setCapacidades(String[] capacidades) {
		Cliente.capacidades = capacidades;
	}
}
