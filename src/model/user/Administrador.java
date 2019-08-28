//en este paquete se maneja todas las clses con respecto al usuario(Autores : el equipo completo)
package model.user;

//clase que genera objetos tipo administrador heredada de usuarios
//ESTRUCTURAS: estan en la clase padre

import java.io.IOException;
import model.exceptionsapp.WrongCredentialsException;

public class Administrador extends Usuario {

	private final static String[] capacidades = {"Listado de Películas", "Listado de Funciones", "Añadir Película", "Eliminar Película", "Crear Función", "Eliminar Función"};


	public Administrador(String usuario, String clave, String nombre, String email, boolean existe) {
		super(usuario, clave, "admin", nombre, email, existe);
		// opciones     "cerrar sesion","actualizar menu","editar pelicula"
	}

	public Administrador(String usuario, String clave) throws WrongCredentialsException, IOException {
		super(usuario, clave, "admin");
	}

	public static String[] getCapacidades() {
		return capacidades;
	}
}
