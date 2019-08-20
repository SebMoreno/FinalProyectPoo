package model.user;

//clase que genera objetos tipo cliente heredada de usuarios
//ESTRUCTURAS: estan en la clase padre

public class Cliente extends Usuario {

	private final Cuenta cuenta;

	public Cliente(String usuario, String clave) {
		this(usuario, clave, "NA");
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

}
