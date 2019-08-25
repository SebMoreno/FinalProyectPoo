/**
 *clase que contiene la vista de la opcion de menu informacion funciones
* @author: Mariana Betancur
 */
package view.MenuRegistrado;
import java.awt.*;
import java.util.Map;
import javax.swing.*;




public class Informacionfunciones extends JPanel{
    
      /*
    Declaracion de las variables
    */
    private JLabel titulo;
    private JPanel panel1 ;
    private JButton go;
    private Choice c;
    private JPanel panel2 ;
    
    /**
     * Constructor de la vista
     * contiene metodo que inicia todas las componentes
     */
   
    public Informacionfunciones(){
     inicializador();
     iniciarComponentes();
     add(panel1 , BorderLayout.EAST);
     add(panel2, BorderLayout.WEST);
     
    }
    private void inicializador(){
        setBounds(10, 170, 375, 150);
       setBackground(Color.WHITE);
       setVisible(true);
    
}
    
    private void iniciarComponentes() {
        /**
         * TODO SOBRE EL SUBPANEL 1
         */
        
        panel1=new JPanel();
        panel1.setBackground(Color.yellow);
        
        /**
         * Etiqueta para el titulo panel 1
         */
        
        titulo=new JLabel("ELIJA UNA PELICULA");
        
        panel1.add(titulo , BorderLayout.CENTER);
        
        /**
         * Boton choice para las peliculas
         */
        c=new Choice();
        panel1.add(c,BorderLayout.CENTER);
        panel1.add(go , BorderLayout.CENTER);
        
        /**
         * Panel para las funciones 
         */
        panel2= new JPanel();
        panel1.setBackground(Color.gray);
        
        
        
        }
        /**
         * Metodo para agregar peliculas en el choice
         */
    
        /**public void choice (){
            if (!gestorAplicacion.cine.Funcion.getFuncionesList().isEmpty()) {
            for (Map.Entry<String, String[]> entry : gestorAplicacion.cine.Funcion.getFuncionesList().entrySet()) {
                this.add((entry.getKey()));
                
            }
            
        }
        }**/
    
    
    
    
    }
