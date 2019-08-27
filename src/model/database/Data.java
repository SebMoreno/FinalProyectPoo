/**
 *Esta clase tiene como finalidad manejar todo lo relacionado con la base de datos y los menus (creacion y generacion de ellos en pantalla)
 * Estructuras relevantes :HashMap<String, OpcionDeMenu> menu_generico (contiene todas las opciones de menu),
 * ArrayList<OpcionDeMenu> options(neccesario para el constructor de menu de consola)
 * @author: Sebastian Moreno , Cristian Mejia
 */

package model.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import model.ExceptionsApp.WrongCredentialsException;
import model.cine.Boleta;
import model.cine.Funcion;
import model.cine.Pelicula;
import model.cine.Sala;
import model.cine.Silla;
import model.user.Cuenta;
import model.user.Usuario;

//Campos de la clase
public class Data {
 /**

     * hace que el pograma lea todos los txt al inicio del programa y tambien crea los menus
     * @see #readAllTxt()----------presente mas abajo en el codigo(linea 175 )
     * @see #createFilesAndDirs()----------presente mas abajo en el codioo(linea 62 )
     * 

    */
    public static void initModel() {
		createFilesAndDirs();
		readAllTxt();
	}

	/*
	static private void crearMenus() {// crea los menus de cada uno de los tipos de usuarios , asi como el inicial y llama al metodo que llena el menu generico
		god_menu_birth();
		menuInicial();
		menuAdmin();
		menuCliente();
		menuInvitado();
	}

	static private void god_menu_birth() {//crea todos los objetos de las clases heredadas de opcion de menú y los agrega al menu generico
		menu_generico.put("iniciar sesion", new IniciarSesion());
		menu_generico.put("comprar boleta", new ComprarBoleta());
		menu_generico.put("recargar saldo", new RecargarSaldo());
		menu_generico.put("registrarse", new Registrarse());
		menu_generico.put("iniciar como invitado", new IniciarComoInvitado());
		menu_generico.put("terminar programa", new Salir());
		menu_generico.put("añadir pelicula", new AñadirPelicula());
		menu_generico.put("eliminar pelicula", new EliminarPelicula());
		menu_generico.put("crear funcion", new CrearFuncion());
		menu_generico.put("eliminar funcion", new EliminarFuncion());
		menu_generico.put("informacion pelicula", new Informacionpelicula());
		menu_generico.put("informacion funciones", new InformacionFunciones());
		menu_generico.put("informacion cuenta", new InformacionCuenta());
	}

	static private void menuInicial() {//metodo que crea el menu inicial(primero que se muestra en pantalla)genera el array de opciones de menu necesario para crea un menu de consola
		ArrayList<OpcionDeMenu> options = new ArrayList<>();
		options.add(menu_generico.get("iniciar sesion"));
		options.add(menu_generico.get("registrarse"));
		options.add(menu_generico.get("iniciar como invitado"));
		options.add(menu_generico.get("terminar programa"));
		menuInicial = new MenuDeConsola(options);
	}

	static private void menuAdmin() {//metodo que crea el menu del administrador ,genera el array de opciones de menu necesario para crea un menu de consola
		ArrayList<OpcionDeMenu> options = new ArrayList<>();
		options.add(menu_generico.get("informacion pelicula"));
		options.add(menu_generico.get("informacion funciones"));
		options.add(menu_generico.get("añadir pelicula"));
		options.add(menu_generico.get("eliminar pelicula"));
		options.add(menu_generico.get("crear funcion"));
		options.add(menu_generico.get("eliminar funcion"));
		options.add(menu_generico.get("terminar programa"));
		Administrador.setMenu(new MenuDeConsola(options));
	}

	static private void menuCliente() {//metodo que crea el menu del cliente ,genera el array de opciones de menu necesario para crea un menu de consola

		ArrayList<OpcionDeMenu> options = new ArrayList<>();
		options.add(menu_generico.get("informacion pelicula"));
		options.add(menu_generico.get("informacion funciones"));
		options.add(menu_generico.get("comprar boleta"));
		options.add(menu_generico.get("informacion cuenta"));
		options.add(menu_generico.get("recargar saldo"));
		options.add(menu_generico.get("terminar programa"));
		Cliente.setMenu(new MenuDeConsola(options));

	}

	static private void menuInvitado() {//metodo que crea el menu del invitado ,genera el array de opciones de menu necesario para crea un menu de consola
		ArrayList<OpcionDeMenu> options = new ArrayList<>();
		options.add(menu_generico.get("registrarse"));
		options.add(menu_generico.get("informacion pelicula"));
		options.add(menu_generico.get("informacion funciones"));
		options.add(menu_generico.get("terminar programa"));
		Invitado.setMenu(new MenuDeConsola(options));
	}
*/
    
    
    /**
     * Metodo para iniciar sesion dependiendo de la informacion ingresada por el usuario
     * @param usuario
     * @param clave
     * @param rol
     * @return
     * @throws WrongCredentialsException
     * @throws IOException 
     */
	public static String[] login(String usuario, String clave, String rol) throws WrongCredentialsException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("temp/" + "usuarios.txt"));
		String line = br.readLine();

		while (line != null) {
			String[] datos = line.split(" ");
			if (datos[0].equals(usuario) && datos[1].equals(clave) && datos[2].equals(rol)) {
				return new String[]{datos[3], datos[4]};
			}
			line = br.readLine();
		}
		throw new WrongCredentialsException();
	}
        /**

     *metodo que lee todos los archivos txt
     * @see gestorAplicacion.usuario.Cuenta#RT() 
     * @see gestorAplicacion.usuario.Usuario#RT() 
     * @see gestorAplicacion.cine.Silla#RT() 
     * @see gestorAplicacion.cine.Pelicula#RT() 
     * @see gestorAplicacion.cine.Sala#RT() 
     * @see gestorAplicacion.cine.Funcion#RT() 
     * @see gestorAplicacion.cine.Boleta#RT() 
     
      */

	public static void readAllTxt() {
		Usuario.RT();
		Cuenta.RT();
		Silla.RT();
		Sala.RT();
		Pelicula.RT();
		Funcion.RT();
		Boleta.RT();
	}
        
          /**

     *metodo para escribir los archivos , utiliza un hashmap para el acceso de los valores dentro del programa
     * @param string archivo, HashMap<String, String[]> lista
     * @exception IOException e
     
     
    */

	public static void writeTxt(String archivo, HashMap<String, String[]> lista) {//metodo para escribir los archivos , utiliza un hashmap para el acceso de los valores dentro del programa
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/temp/" + archivo))) {
			for (Map.Entry<String, String[]> entry : lista.entrySet()) {
				bw.write(entry.getKey());
				for (String value : entry.getValue()) {
					bw.write(" " + value);
				}
				bw.newLine();
			}
		} catch (IOException e) {

			
		}

	}
        
         /**

     *metodo para escribir los archivos , utiliza un hashmap para el acceso de los valores dentro del programa
     * @param String archivo, HashMap<String, String[]> lista
     * @exception IOException e 
     * lee linea por linea el txt y lo guarda en el arreglo datos, luego utuliza aux como value del hash y el primer indice de datos com key 
     
     
    */
        

	public static void readTxt(String archivo, HashMap<String, String[]> lista) {
		try (BufferedReader br = new BufferedReader(new FileReader("temp/" + archivo))) {
			String line = br.readLine();

			while (line != null) {
				String[] datos = line.split(" ");
				String[] aux = new String[datos.length - 1];
				System.arraycopy(datos, 1, aux, 0, (datos.length - 1));
				lista.put(datos[0], aux);
				line = br.readLine();
			}
		} catch (IOException e) {
			
		}

	}
        
        /**
         * metodo que permite crear archivos con la informacion de los txt de la base de datos
         */

	public static void createFilesAndDirs() {
		try {
			String ruta = System.getProperty("user.dir") + "\\temp\\";
			File directory = new File(ruta);
			if (!directory.exists()) {
				directory.mkdir();
			}
			new File(ruta + "boletas.txt").createNewFile();
			new File(ruta + "cuentas.txt").createNewFile();
			new File(ruta + "funciones.txt").createNewFile();
			new File(ruta + "peliculas.txt").createNewFile();
			new File(ruta + "salas.txt").createNewFile();
			new File(ruta + "sillas.txt").createNewFile();
			new File(ruta + "usuarios.txt").createNewFile();
		} catch (IOException e) {
			
		}
	}
}
