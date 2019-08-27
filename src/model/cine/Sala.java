/**
 *clase encarga de crear las salas , necesaria para las clases funciones y sillas , tambien necesaria para comprar boletas
 *ESTRUCTRAS:HashMap<String, String[]> salasList (guardar los datos en el txt), Silla[][] sillas(como esta arreglada la sala)
 * @author: Sebastian Moreno , Cristian Mejia, Mariana Betancur , Jairo cortez
 */

package model.cine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.database.Data;

//Campos de la clase
public class Sala {

	private final static HashMap<String, String[]> salasList = new HashMap<>(); // key: idSala     value: precio, tipo, capacidad, sizeV, sizeH, idSilla[0][0], idSilla [0][1], ... , idSilla[n][n]
	private final int idSala;
	private final String tipo;
	private final int capacidad;
	private final Silla[][] sillas;
	private int precio;
         /**
     * Constructor para crear objetos que ya estan en los Txt
     * @param idSala 
     */
	public Sala(String idSala) {//Constructor para crear objetos que ya estan en los Txt
		this.idSala = Integer.parseInt(idSala);
		precio = Integer.parseInt(salasList.get(idSala)[0]);
		tipo = salasList.get(idSala)[1];
		capacidad = Integer.parseInt(salasList.get(idSala)[2]);
		sillas = new Silla[Integer.parseInt(salasList.get(idSala)[3])][Integer.parseInt(salasList.get(idSala)[4])];
		for (int i = 0; i < Integer.parseInt(salasList.get(idSala)[3]); i++) {
			for (int j = 0; j < Integer.parseInt(salasList.get(idSala)[4]); j++) {
				sillas[i][j] = new Silla(salasList.get(idSala)[i * (Integer.parseInt(salasList.get(idSala)[4])) + j + 5], this);
			}
		}
	}
 /**
     * constructor para guardar en el txt, depende del tipo de la sala cambia el precio
     * @param tipo
     * @param tamañoVertical
     * @param tamañoHorizontal
     * @param filasVibrosound
     * @param filasPreferencial 
     * @see baseDeDatos.Data#writeTxt(java.lang.String, java.util.HashMap) 
     */
	public Sala(String tipo, int sizeVertical, int sizeHorizontal, int filasVibrosound, int filasPreferencial) {
		this.sillas = crearMatrizSillas(sizeVertical, sizeHorizontal, filasVibrosound, filasPreferencial);
		this.capacidad = sizeVertical * sizeHorizontal;
		/*Se le asigna un ID nuevo a la sala*/
		int mayorId = 0, aux;
		for (Map.Entry<String, String[]> entry : salasList.entrySet()) {
			aux = Integer.parseInt(entry.getKey());
			if (mayorId < aux) {
				mayorId = aux;
			}
		}
		this.idSala = mayorId + 1;
		/*Se le asigna el precio segun tipo de sala*/
		switch (tipo) {
			case "2D":
				this.tipo = tipo;
				this.precio = 10000;
				break;
			case "3D":
				this.tipo = tipo;
				this.precio = 12000;
				break;
			case "IMAX":
				this.tipo = tipo;
				this.precio = 15000;
				break;
			case "DINAMIX":
				this.tipo = tipo;
				this.precio = 18000;
				break;
			default:
				this.tipo = "2D";
				this.precio = 10000;
		}
		/*Empieza el proceso de guardado en el Txt*/
		ArrayList<String> valor = new ArrayList<>();
		valor.add(Integer.toString(this.precio));
		valor.add(this.tipo);
		valor.add(Integer.toString(this.capacidad));
		valor.add(Integer.toString(sillas.length));
		valor.add(Integer.toString(sillas[0].length));
		int i = 0;
		for (i = 0; i < sillas.length; i++) {
			for (int j = 0; j < sillas[0].length; j++) {
				if (sillas[i][j] == null) {
					valor.add("NA");
				} else {
					valor.add(Integer.toString(sillas[i][j].getIdSilla()));
				}
			}
		}

		String[] value = new String[valor.size()];
		i = 0;
		for (String iter : valor) {
			value[i] = iter;
			i++;
		}
		salasList.put(Integer.toString(idSala), value);
		Data.writeTxt("salas.txt", salasList);
	}
/**

     *cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
     * @see baseDeDatos.Data#readTxt(String , HashMap<String, String[]> lista)
     */
	public static void RT() {//cada clase que tiene informacion en un archivo txt tiene este metodo para leer el respectivo archivoy guardarlo en su hashmap
		Data.readTxt("salas.txt", salasList);
	}

	public static HashMap<String, String[]> getSalasList() {
		return salasList;
	}
        
         /**
     * crea las matrices de silla y devuelve es matriz
     * @param tamañoVertical
     * @param tamañoHorizontal
     * @param filasVibrosound
     * @param filasPreferencial
     * @return Silla[][] s
     */

	private Silla[][] crearMatrizSillas(int sizeVertical, int sizeHorizontal, int filasVibrosound, int filasPreferencial) {//crea las matrices de silla y devuelve es matriz
		Silla[][] s = new Silla[sizeVertical][sizeHorizontal];
		int val = filasVibrosound - filasPreferencial;
		if (val > 0) {
			for (int i = 0; i < filasPreferencial; i++) {//entonces la silla que esta en esa posicion es vibrasound, es preferencial y no esta ocupada
				for (int j = 0; j < sizeHorizontal; j++) {
					s[i][j] = new Silla(this, i, j, true, true, false);
				}
			}
			for (int i = filasPreferencial; i < filasVibrosound; i++) {//sillas orefenciales y no vibrasound
				for (int j = 0; j < sizeHorizontal; j++) {
					s[i][j] = new Silla(this, i, j, true, false, false);
				}
			}
			for (int i = filasVibrosound; i < sizeVertical; i++) {//sillas normales
				for (int j = 0; j < sizeHorizontal; j++) {
					s[i][j] = new Silla(this, i, j, false, false, false);
				}
			}
		} else {//lo mismo pero teniendo en cuenta vibrasound(ya que es el mayor valor)

			for (int i = 0; i < filasVibrosound; i++) {
				for (int j = 0; j < sizeHorizontal; j++) {
					s[i][j] = new Silla(this, i, j, true, true, false);
				}
			}
			for (int i = filasVibrosound; i < filasPreferencial; i++) {
				for (int j = 0; j < sizeHorizontal; j++) {
					s[i][j] = new Silla(this, i, j, false, true, false);
				}
			}
			for (int i = filasPreferencial; i < sizeVertical; i++) {
				for (int j = 0; j < sizeHorizontal; j++) {
					s[i][j] = new Silla(this, i, j, false, false, false);
				}
			}
		}
		return s;
	}

         /**
     * Devuelve el precio de la sala
     * @return precio
     */
        
	public int getPrecio() {
		return precio;
	}
    /**
     *Devuelve el tipo de la sala
     * @return 
     */
        
        public String getTipo() {
		return tipo;
	}
/**
     * Devulve la capacidad de la sala
     * @return capacidad
     */
	public int getCapacidad() {
		return capacidad;
	}
/**
     * Devuelve el ID de la sala
     * @return 
     */
	public int getIdSala() {
		return idSala;
	}
        
          /**
     * busca la silla en la posicion indicada y devuelve null si no la encuentra
     * verifica que no entran errores en esta busqueda
     * @param posicionX
     * @param posicionY
     * @return null si no encuentra la silla
     */

	public Silla getSilla(int posicionX, int posicionY) {
		if (posicionX <= sillas.length) {
			if (posicionY <= sillas[0].length) {
				return sillas[posicionX][posicionY];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Silla[][] getSillas() {
		return sillas;
	}

	/*Imprime todos los lugares de las sillas por consola mostrando si son:
		P: premium, es decir, vibrosound y preferenciales a la vez
		v: vibrosound
		p: preferenciales
		n: normales

		Acompañada a esta letra siempre estará o una L(silla libre) o una O(silla ocupada)
	 */
	@Override
	public String toString() {
		StringBuilder sala = new StringBuilder("  ");
		;
		for (int i = 0; i < this.sillas.length; i++) {
			sala.append(i).append("  ");
		}
		sala.append("\n");
		for (int i = 0; i < this.sillas.length; i++) {
			sala.append(i).append(" ");
			for (int j = 0; j < this.sillas[0].length; j++) {
				if (this.getSillas()[i][j].isOcupada()) {
					if (this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
						sala.append("PO ");
					} else if (!this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
						sala.append("vO ");
					} else if (this.getSillas()[i][j].isPreferencial() && !this.getSillas()[i][j].isVibrosound()) {
						sala.append("pO ");
					} else {
						sala.append("nO ");
					}
				} else {
					if (this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
						sala.append("PL ");
					} else if (!this.getSillas()[i][j].isPreferencial() && this.getSillas()[i][j].isVibrosound()) {
						sala.append("vL ");
					} else if (this.getSillas()[i][j].isPreferencial() && !this.getSillas()[i][j].isVibrosound()) {
						sala.append("pL ");
					} else {
						sala.append("nL ");
					}
				}
			}
			sala.append("\n");
		}
		return sala.toString();
	}

}
