//en este paquete se maneja todas las clses con respecto al usuario(Autores : el equipo completo)
package model.user;

//clase que genera objetos tipo administrador heredada de usuarios
//ESTRUCTURAS: estan en la clase padre

import java.io.IOException;
import model.ExceptionsApp.WrongCredentialsException;
import model.cine.Pelicula;

public class Administrador extends Usuario {

	private static String[] capacidades = {"Listado de Películas", "Listado de Funciones", "Añadir Película", "Eliminar Película", "Crear Función", "Eliminar Función"};




	public Administrador(String usuario, String clave, String nombre, String email, boolean existe) {
		super(usuario, clave, "admin", nombre, email, existe);
		// opciones     "cerrar sesion","actualizar menu","editar pelicula"
	}
	public Administrador(String usuario, String clave) throws WrongCredentialsException, IOException {
		super(usuario,clave,"admin");
	}

	//TODO Mira esta belleza de metodo, es increibleamazing
	private void createmovie(String titulo, String genero, String clasificacion, String duracion, String idioma) { //de qui en adelante con los metodos que necesitan las opciones que hacen que el administrador para editar otras funciones
		Pelicula nueva = new Pelicula(titulo, genero, clasificacion, duracion, idioma);
	}

	public static void setCapacidades(String[] capacidades) {
		Administrador.capacidades = capacidades;
	}

	public static String[] getCapacidades() {
		return capacidades;
	}
}
