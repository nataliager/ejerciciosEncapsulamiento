/**
 * Ejercicio 3 PasswordApp
 * Clase principal main
 * Creation date: 04/08/2021
 * Last modified date: 04/08/2021
 * @author Natalia Giraldo
 */
package ejercicios_encapsulamiento;
import javax.swing.JOptionPane;

public class PasswordApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Introducimos el tamaño del array y la longitud del password
        String texto=JOptionPane.showInputDialog("Introduce un tamaño para el array");
        int tamaño=Integer.parseInt(texto);
        
        texto=JOptionPane.showInputDialog("Introduce la longitud del password");
        int longitud=Integer.parseInt(texto);
        
        //Creamos los arrays
        Password listaPassword[]=new Password[tamaño]; //Lista de objetos password
        boolean fortalezaPassword[]=new boolean[tamaño]; //Lista de booleanos
        
        //Creamos objetos, indicamos si es fuerte y mostramos la contraseña y 
        //su fortaleza.
        for(int i=0;i<listaPassword.length;i++){
            listaPassword[i]=new Password(longitud);
            fortalezaPassword[i]=listaPassword[i].esFuerte();
            System.out.println(listaPassword[i].getContraseña()+" "+fortalezaPassword[i]);
        }
    }//Fin del metodo main
   
}//Fin de la clase PasswordApp
