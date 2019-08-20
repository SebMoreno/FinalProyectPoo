//en este paquete se maneja todas las clses con respecto al usuario(Autores : el equipo completo)
package model.user;

//clase que genera objetos tipo administrador heredada de usuarios
//ESTRUCTURAS: estan en la clase padre

import model.cine.Pelicula;

public class Administrador extends Usuario {

	public Administrador(String usuario, String clave) {
		this(usuario, clave, "NA");
	}

	public Administrador(String usuario, String clave, String nombre) {
		this(usuario, clave, nombre, "NE", false);
	}

	public Administrador(String usuario, String clave, String nombre, String email, boolean existe) {
		super(usuario, clave, "admin", nombre, email, existe);
		// opciones     "cerrar sesion","actualizar menu","editar pelicula"
	}

	//TODO Mira esta belleza de metodo, es increibleamazing
	private void createmovie(String titulo, String genero, String clasificacion, String duracion, String idioma) { //de qui en adelante con los metodos que necesitan las opciones que hacen que el administrador para editar otras funciones
		Pelicula nueva = new Pelicula(titulo, genero, clasificacion, duracion, idioma);
	}
}
