package model.user;

import java.io.IOException;
import java.util.HashMap;
import model.database.Data;
import model.exceptionsapp.WrongCredentialsException;

import static model.database.Data.readTxt;
import static model.database.Data.writeTxt;

/*
clase padre de todos los usuarios , aqui esta el constructor de todos y es necesaria para el funcionamiento del programa
ESTRUCTURA: HashMap<String, String[]> usersList (guardar informacion usuarios)
esta sera mi super clase por eso tiene  lo que puede hacer un usuario
*/
public abstract class Usuario {


	private static HashMap<String, String[]> usersList = new HashMap<>(); // key: usuario    value: clave, rol, nombre, email
	private final String usuario;
	private final String rol;
	private String clave;
	private String nombre;
	private String email;

	protected Usuario(String usuario, String clave, String rol, String nombre, String email, boolean existe) {//cosntructor usuarios que se necesitan para acceder a metodos
		this.clave = clave;
		this.rol = rol;
		this.nombre = nombre;
		this.email = email;
		this.usuario = usuario;
		if (!existe) {
			String[] aux = {clave, rol, nombre, email};
			usersList.put(usuario, aux);
			writeTxt("usuarios.txt", usersList);
		}
	}

	protected Usuario(String usuario, String clave, String rol) throws WrongCredentialsException, IOException {
		String[] aux = Data.login(usuario, clave, rol);
		this.clave = clave;
		this.rol = rol;
		this.usuario = usuario;
		this.nombre = aux[0];
		this.email = aux[1];
	}

	public static void RT() {//metodo para leer la informacion del txt , presente en todas las clases que se guardan en un txt
		readTxt("usuarios.txt", usersList);
	}

	public static HashMap<String, String[]> getUsersList() {
		return usersList;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getRol() {
		return rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
