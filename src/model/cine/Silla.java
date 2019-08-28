/**
 * clase que crea las sillas , necesaria para boleta , sala (por la matriz) y para generar la boleta
 * Estructuras:HashMap<String, String[]> sillasList
 *
 * @author: Sebastian Moreno , Cristian Mejia, Mariana Betancur , Jairo cortez
 */


package model.cine;


import java.util.HashMap;
import java.util.Map;

import static model.database.Data.readTxt;
import static model.database.Data.writeTxt;


public class Silla {

	private final boolean vibrosound;
	private final boolean preferencial;
	private final Short incremento;
	private final Sala sala;
	private final String posicion;
	private final int idSilla;
	private final int posV;
	private final int posH;
	private boolean ocupada;

	private final static HashMap<String, String[]> sillasList = new HashMap<>(); // key: idSilla     value: incremento, vibrosound, preferencial, ocupada, posicion, idSala

	/**
	 * cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
	 *
	 * @see baseDeDatos.Data#readTxt(String, HashMap<String, String[]> lista)
	 */
	public static void RT() {////cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
		readTxt("sillas.txt", sillasList);
	}

	/**
	 * Constructor para crear objetos que ya estan en los Txt
	 *
	 * @param idSilla
	 * @param sala
	 */
	public Silla(String idSilla, Sala sala) {//Constructor para crear objetos que ya estan en los Txt
		this.idSilla = Integer.valueOf(idSilla);
		this.sala = sala;
		incremento = Short.valueOf(sillasList.get(idSilla)[0]);
		vibrosound = Boolean.parseBoolean(sillasList.get(idSilla)[1]);
		preferencial = Boolean.parseBoolean(sillasList.get(idSilla)[2]);
		ocupada = Boolean.parseBoolean(sillasList.get(idSilla)[3]);
		posicion = sillasList.get(idSilla)[4];
		posV = posicion.charAt(0);
		posH = posicion.charAt(2);
	}

	/**
	 * constructor al crear silla , tiene en cuenta el tipo para el incremento
	 *
	 * @param sala
	 * @param posV
	 * @param posH
	 * @param vibrosound
	 * @param preferencial
	 * @param ocupada
	 * @see baseDeDatos.Data#writeTxt(java.lang.String, java.util.HashMap)
	 */
	public Silla(Sala sala, int posV, int posH, boolean vibrosound, boolean preferencial, boolean ocupada) {//constructor al crear silla , tiene en cuenta el tipo para el incremento
		this.sala = sala;
		this.posV = posV;
		this.posH = posH;
		this.posicion = Integer.toString(posV) + "." + Integer.toString(posH);
		this.vibrosound = vibrosound;
		this.preferencial = preferencial;
		this.ocupada = ocupada;
		if (vibrosound && preferencial) {
			this.incremento = 2000;
		} else if (vibrosound && !preferencial) {
			this.incremento = 1500;
		} else if (!vibrosound && preferencial) {
			this.incremento = 500;
		} else {
			this.incremento = 0;
		}
		int mayorId = 0, aux;
		for (Map.Entry<String, String[]> entry : sillasList.entrySet()) {
			aux = Integer.valueOf(entry.getKey());
			if (mayorId < aux) {
				mayorId = aux;
			}
		}
		this.idSilla = mayorId + 1;
		String[] valor = {Integer.toString(this.incremento), Boolean.toString(vibrosound), Boolean.toString(preferencial), Boolean.toString(ocupada), this.posicion, Integer.toString(this.sala.getIdSala())};
		sillasList.put(Integer.toString(idSilla), valor);
		writeTxt("sillas.txt", sillasList);
	}

	/**
	 * Constructor que llama al constructor principal presente en el codio y llena los parametros necesarios por default
	 *
	 * @param sala
	 * @param posV
	 * @param posH
	 * @param vibrosound
	 * @param preferencial
	 */

	public Silla(Sala sala, int posV, int posH, boolean vibrosound, boolean preferencial) {
		this(sala, posV, posH, false, false, false);
	}

	/**
	 * Constructor que llama a el constructor que tiene los 5 parametros presentadors en el this
	 *
	 * @param sala
	 * @param posV
	 * @param posH
	 */

	public Silla(Sala sala, int posV, int posH) {
		this(sala, posV, posH, false, false);
	}

	/**
	 * boolean que dice si es o no es Vibrosound
	 *
	 * @return vibrosound
	 */

	public boolean isVibrosound() {
		return vibrosound;
	}

	/**
	 * boolean que dice si es o no es preferencial
	 *
	 * @return preferencial
	 */
	public boolean isPreferencial() {
		return preferencial;
	}


	/**
	 * Devuelve el incremento de la silla seleccionada
	 *
	 * @return incremento
	 */
	public Short getIncremento() {
		return incremento;
	}

	/**
	 * Devuelve la sala a la que peretenece la silla
	 *
	 * @return sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * Devuelve el registro de las sillas
	 *
	 * @return sillasList
	 */


	public static HashMap<String, String[]> getSillasList() {
		return sillasList;
	}

	/**
	 * Si el boolean devuelve verdadero devuelve ocupada
	 *
	 * @return ocupada
	 */
	public boolean isOcupada() {
		return ocupada;
	}

	/**
	 * al momento de comprar se llama este metodo para cambiar el booleano que determina eso
	 *
	 * @param ocupada
	 */
	public void setOcupada(boolean ocupada) {//al momento de comprar se llama este metodo para cambiar el booleano que determina eso
		this.ocupada = ocupada;

		String[] aux = sillasList.get(Integer.toString(idSilla));
		aux[3] = Boolean.toString(ocupada);
		sillasList.put(Integer.toString(idSilla), aux);
	}

	/**
	 * Devuleve la posicion
	 *
	 * @return posicion
	 */

	public String getPosicion() {
		return posicion;
	}


	/**
	 * Devuelve el id de la silla
	 *
	 * @return IdSilla
	 */

	public int getIdSilla() {
		return idSilla;
	}

}
