/**
 *Clase que contiene toda la informacion de las peliculas , necesaria para poder comprar boleetas y generar funciones 
 *ESTRUCTURAS:HashMap<String, String[]> pelisList (Para escribir en el txt)
 * @author: Sebastian Moreno , Cristian Mejia, Mariana Betancur , Jairo cortez
 */

package model.cine;


import java.util.HashMap;
import model.database.Data;


public class Pelicula {

	private final String genero;
	private final String clasificacion;
	private final String titulo;
	private final String duracion;
	private final String idioma;
	private final static HashMap<String, String[]> pelisList = new HashMap<>(); // key: titulo     value: genero, clasificacion, duracion, idioma

        
        /**

     *cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
     * @see baseDeDatos.Data#readTxt(java.lang.String, java.util.HashMap) 
     */
	public static void RT() {
		Data.readTxt("peliculas.txt", pelisList);
	}

        /**
     * Constructor para crear objetos que ya estan en los Txt
     * @param titulo 
     */
        
	public Pelicula(String titulo) { 
		genero = pelisList.get(titulo)[0];
		clasificacion = pelisList.get(titulo)[1];
		this.titulo = titulo;
		duracion = pelisList.get(titulo)[2];
		idioma = pelisList.get(titulo)[3];
	}

         /**
     * contructor que escribe en los txt
     * @param titulo
     * @param genero
     * @param clasificacion
     * @param duracion
     * @param idioma 
     * @see baseDeDatos.Data#writeTxt(java.lang.String, java.util.HashMap) 
     */
	public Pelicula(String titulo, String genero, String clasificacion, String duracion, String idioma) {//contructor que escribe en los txt
		this.genero = genero;
		this.clasificacion = clasificacion;
		this.titulo = titulo;
		this.duracion = duracion;
		this.idioma = idioma;
		String[] aux = {genero, clasificacion, duracion, idioma};
		pelisList.put(titulo, aux);
		Data.writeTxt("peliculas.txt", pelisList);
	}
        /**
     * metodo necesario para la opcion de administrador borrar pelicula
     * @param titulo 
     * @see baseDeDatos.Data#writeTxt(java.lang.String, java.util.HashMap) 
     */

	// TODO Arreglar el borrado de Peliculas para que no imprima nada por pantalla
	public static void delete(String titulo) {//metodo necesario para la opcion de administrador borrar pelicula
		if (pelisList.containsKey(titulo)) {
			System.out.println("Haz borrado " + pelisList.remove(titulo) + " de la cartelera");
		} else {
			System.out.println("El título de esa película no está registrado\nNo se ha realizado ninguna modificación");
		}
		Data.writeTxt("peliculas.txt", pelisList);
	}

	public String getGenero() {
		return genero;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDuracion() {
		return duracion;
	}

	public String getIdioma() {
		return idioma;
	}

	public static HashMap<String, String[]> getPelisList() {
		return pelisList;
	}

}
