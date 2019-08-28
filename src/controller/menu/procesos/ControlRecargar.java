package controller.menu.procesos;


import controller.ControladorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.database.Data;
import model.user.Cliente;
import model.user.Cuenta;
import view.UsuarioAdministrador.RecargarSaldo;

public class ControlRecargar extends ControladorVista implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String saldoARecargar = ((RecargarSaldo) ControladorVista.getPantallaActual()).getCampo_texto().getText();
		int saldoActual = ((Cliente) ControladorVista.getUsuarioActivo()).getCuenta().getSaldo();
		int saldonuevo = saldoActual + Integer.parseInt(saldoARecargar);
		((Cliente) ControladorVista.getUsuarioActivo()).getCuenta().setSaldo(saldonuevo);
		Data.writeTxt("cuentas.txt", Cuenta.getCuentasList());
		ControladorVista.getPantallaActual().muestraDatos("Se ha recargado su saldo con éxito");
		((RecargarSaldo)ControladorVista.getPantallaActual()).getSaldo_actual().setText("Su saldo actual es: "+ saldonuevo);
		ControladorVista.packActualFrame();
	}
}



