package controller.inicio;

import controller.ControladorVista;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class ControlBienvenida extends ControladorVista implements MouseListener {


	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		JLabel source = (JLabel) mouseEvent.getSource();
		source.setForeground(Color.BLUE);

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		JLabel source = (JLabel) mouseEvent.getSource();
		source.setForeground(Color.BLACK);

	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}
}
