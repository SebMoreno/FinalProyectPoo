package view.UsuarioAdministrador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.ArrayList;

public class FieldPanel extends JPanel {
        ArrayList<JTextField> TextFields = new ArrayList<>();
        String [] Criterios;

	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
        JPanel panelLabels = new JPanel();
        JPanel panelForm = new JPanel();
        Criterios = criterios;

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
                                TextFields.add(textField);

			}
		} catch (NullPointerException e1) {

			for (int i = 0; i < criterios.length; i++) {
				panelForm.add(new JLabel(criterios[i]));
                                JTextField textField = new JTextField(valores[i]);
				panelForm.add(textField);
                                TextFields.add(textField);
			}

		}

	}


	public String getValue(String criterio) {

                int index=0;
                for (int i=0; i<Criterios.length; i++){
                    if (Criterios[i]==criterio){
                        index=i;
                    }
                }
                return TextFields.get(index).getText();
	}

	public ArrayList<JTextField> getTextFields() {
		return TextFields;
	}
}
