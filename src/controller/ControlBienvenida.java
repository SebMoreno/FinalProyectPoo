package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ControlBienvenida extends MouseAdapter implements ControladorVista {

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
}
