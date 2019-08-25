package View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FieldPanel extends JPanel {
	/* Empieza declaraciÃ³n de subobjetos pertenencientes a este objeto principal */
        private ArrayList <String> criterios = new ArrayList<>();
        private ArrayList <String> valores = new ArrayList<>();
	/* Fin declaraciÃ³n */

	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new GridLayout(criterios.length + 1, 2));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                this.add(new JLabel(tituloCriterios));
                this.add(new JLabel(tituloValores));
                
                for(int i=0; i<criterios.length; i++){
                    this.add(new JLabel(criterios[i]));
                    this.criterios.add(criterios[i]);
                    this.valores.add(valores[i]);
                    JTextField textField = new JTextField();
                    if (habilitado[i]==false){
                        textField.setEditable(false);
                        this.add(textField);
                    }
                    else{
                        textField.setEditable(true);
                        this.add(textField);
                    }
                }
		/* Fin Agregado de Componentes */


		//Si es un JFrame colocar lo siguiente
		/*


		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Ojo con esta linea, eliminar al finalizar el diseÃ±o
		setSize(700, 500);                                         // setSize(int tamaÃ±oX, int tamaÃ±oY);
		setVisible(true);

		 */
	}
        
        public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String apuntador) {
		/* OrganizaciÃ³n de Layout */
                this.setLayout(new GridLayout(criterios.length + 1, 2));
		/* Fin Layout */

		/* Operaciones Adicionales */
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                this.add(new JLabel(tituloCriterios));
                this.add(new JLabel(tituloValores));
                
                for(int i=0; i<criterios.length; i++){
                    this.add(new JLabel(criterios[i]));
                    this.criterios.add(criterios[i]);
                    this.add(new JTextField());
                }
		/* Fin Agregado de Componentes */


		//Si es un JFrame colocar lo siguiente
		/*


		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //Ojo con esta linea, eliminar al finalizar el diseÃ±o
		setSize(700, 500);                                         // setSize(int tamaÃ±oX, int tamaÃ±oY);
		setVisible(true);

		 */
	}

	/* Metodos auxiliares */
        public String getValue(String criterio){
            return valores.get(criterios.indexOf(criterio));
        }
	/* Fin Metodos auxiliares */


}
