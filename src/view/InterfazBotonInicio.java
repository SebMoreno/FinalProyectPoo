package view;


import javax.swing.JFrame;
import model.exceptionsapp.NotFillFieldsAdminException;
import model.exceptionsapp.NotFillFieldsClientException;

public interface InterfazBotonInicio extends InterfazPanel {

	void apareceFormulario();

	void packInicio();

	void isAdminEntering(boolean isIt);

	int quiereSalir();

	void mostrarError(String error, String titulo, int icono);

	JFrame getActualFrame();

	String getUsuario() throws NotFillFieldsAdminException, NotFillFieldsClientException;

	String getClave() throws NotFillFieldsAdminException, NotFillFieldsClientException;

}
