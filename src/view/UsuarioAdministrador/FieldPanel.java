package view.UsuarioAdministrador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FieldPanel extends JPanel {

	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
        JPanel panelLabels = new JPanel();
        JPanel panelForm = new JPanel();

        setLayout(new BorderLayout(3,3));
        panelForm.setLayout(new GridLayout(criterios.length, 2, 5, 10));
	    panelLabels.setLayout(new BorderLayout(3,3));

        panelLabels.add(new JLabel(tituloCriterios, SwingConstants.CENTER), BorderLayout.CENTER);
        panelLabels.add(new JLabel(tituloValores, SwingConstants.CENTER), BorderLayout.EAST);
        add(panelLabels, BorderLayout.NORTH);
        add(panelForm, BorderLayout.CENTER);


		try {
			for (int i = 0; i < criterios.length; i++) {
				JTextField textField = new JTextField(valores[i]);
				if (!habilitado[i]) {
					textField.setEditable(false);
				} else {
					textField.setEditable(true);
				}
				panelForm.add(new JLabel(criterios[i]));
				panelForm.add(textField);

			}
		} catch (NullPointerException e1) {

			for (int i = 0; i < criterios.length; i++) {
				panelForm.add(new JLabel(criterios[i]));
				panelForm.add(new JTextField(valores[i]));
			}

		}

	}


	public String getValue(String criterio) {
		return "Esta malo pai"; // TODO Cristo arreglelo pai
	}

}
