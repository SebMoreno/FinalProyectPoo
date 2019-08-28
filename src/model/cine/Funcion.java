/**
 * Clase con las funciones del cinema , necesario para la compra de boletas
 * ESTRUCTURAS:ESTRUCTURAS:HashMap<String, String[]> funcionesList
 *
 * @author: Sebastian Moreno , Cristian Mejia, Mariana Betancur , Jairo cortez
 */


package model.cine;


import java.util.HashMap;
import java.util.Map;
import model.database.Data;

//Campos de la clase
public class Funcion {

	private final static HashMap<String, String[]> funcionesList = new HashMap<>(); // key: idFuncion     value: idSala, tituloPelicula, hora, sillasOcupadas
	private final int idFuncion;
	private Sala sala;
	private Pelicula pelicula;
	private String hora;
	private Short sillasOcupadas;

	/**
	 * Constructor para crear objetos que ya estan en los Txt, dado que se necesite para llamar algo metodo
	 *
	 * @param String
	 */
	public Funcion(String idFuncion) {
		sala = new Sala(funcionesList.get(idFuncion)[0]);
		pelicula = new Pelicula(funcionesList.get(idFuncion)[1]);
		hora = funcionesList.get(idFuncion)[2];
		sillasOcupadas = Short.valueOf(funcionesList.get(idFuncion)[3]);
		this.idFuncion = Integer.parseInt(idFuncion);

	}

	/**
	 * metodo que permite crear objetos que si se quieren guardar en el txt
	 *
	 * @param (Sala sala,String hora,Pelicula pelicula)
	 * @see baseDeDatos.Data#writeTxt(java.lang.String, java.util.HashMap)
	 */

	public Funcion(Sala sala, String hora, Pelicula pelicula) {
		this.sala = sala;
		this.hora = hora;
		this.pelicula = pelicula;
		int mayorId = 0, aux;
		for (Map.Entry<String, String[]> entry : funcionesList.entrySet()) {
			aux = Integer.parseInt(entry.getKey());
			if (mayorId < aux) {
				mayorId = aux;
			}
		}
		this.idFuncion = mayorId + 1;
		String[] valor = {Integer.toString(sala.getIdSala()), pelicula.getTitulo(), hora, "0"};
		funcionesList.put(Integer.toString(idFuncion), valor);
		Data.writeTxt("funciones.txt", funcionesList);
	}

	/**
	 * cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
	 *
	 * @see baseDeDatos.Data#readTxt(String archivo, HashMap<String, String[]> lista)
	 */


	public static void RT() {////cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
		Data.readTxt("funciones.txt", funcionesList);
	}


	public static HashMap<String, String[]> getFuncionesList() {
		return funcionesList;
	}

	/**
	 * El administrador puede hacer esto , entonces la remueve de el hashmap y en esa opcion de menu(en el ui main)vuelve a escribir el archivo
	 *
	 * @param id
	 */
	public static void deleteFuncion(String id) {
		if (funcionesList.containsKey(id)) {
			funcionesList.remove(id);
			System.out.println("La función ha sido eliminada exitosamente.");
		} else {
			System.out.println("No se ha enconrado ninguna fuinción\nNo se han realizado cambios.");
		}
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Short getSillasOcupadas() {
		return sillasOcupadas;
	}

	public void setSillasOcupadas(Short sillasOcupadas) { // key: idFuncion     value: idSala, tituloPelicula, hora, sillasOcupadas
		this.sillasOcupadas = sillasOcupadas;
		String[] aux = funcionesList.get(Integer.toString(idFuncion));
		aux[3] = Short.toString(sillasOcupadas);
		funcionesList.put(Integer.toString(idFuncion), aux);
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

}
