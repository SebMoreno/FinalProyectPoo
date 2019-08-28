package controller.inicio;

import controller.ControladorVista;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ControlFoto extends ControladorVista implements ActionListener {
	private int fotoActual = 1;

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (fotoActual == 3) {
			fotoActual = 1;
		} else {
			fotoActual++;
		}
		JButton foto = (JButton) actionEvent.getSource();
		foto.setIcon(new ImageIcon(new ImageIcon("temp\\" + fotoActual + ".gif").getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT)));
	}
}
