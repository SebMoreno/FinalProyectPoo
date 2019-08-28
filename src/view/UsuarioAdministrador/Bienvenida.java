package view.UsuarioAdministrador;

import controller.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import view.InterfazPanel;

/**
 * @author Cristianm120
 */
public class Bienvenida extends JPanel implements InterfazPanel {
	/* Empieza declaración de subobjetos pertenencientes a este objeto principal */
	private JTextArea area = new JTextArea("                         ¡Bienvenido!\n" + 
                "\n" + 
                "                      El equipo de\n" + 
                "\n" + 
                "                            CineX\n" + 
                "\n" + 
                "                 está entusiasmado\n" + 
                "\n" + 
                "                      con su visita\n" + 
                "\n" + 
                "                       DISFRUTE");
        private Image background;
	JButton boton = new JButton("Continuar");
	/* Fin declaración */

	public Bienvenida(String imagePath) {
		/* Organización de Layout */
		this.setLayout(new GridLayout(3, 3));
		/* Fin Layout */

		/* Operaciones Adicionales */
		setPreferredSize(new Dimension(600, 600));
                setBackground(imagePath);
                area.setSize(200,200);
                area.setEditable(false);
                boton.setPreferredSize(new Dimension(70,50));
		/* Fin Operaciones Adicionales */

		/* Agregado de Componentes */
                for(int i=0; i<9; i++){
                    if (i==4){
                        add(area);
                    }
                    else if (i==7){
                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout(7,15));
                        panel.setOpaque(false);
                        add(panel);
                    }
                    else{
                        JPanel panel = new JPanel();
                        panel.setOpaque(false);
                        this.add(panel);
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

	@Override
	public void setController(ControladorVista[] controllers) {
		boton.addActionListener((ActionListener) controllers[0]);
	}

	@Override
	public void muestraDatos(String textoParaMostrar) {
		
	}

	/* Metodos auxiliares */
        // Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
	public void paintComponent(Graphics g) {
 
		/* Obtenemos el tamaño del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		// Mandamos que pinte la imagen en el panel
		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
		}
 
		super.paintComponent(g);
	}
        
        // Metodo donde le pasaremos la dirección de la imagen a cargar.
	public void setBackground(String imagePath) {
		
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}
	/* Fin Metodos auxiliares */
}

