/**
 * Ejercicio 3 clase Password
 * Creation date: 04/08/2021
 * Last modified date: 04/08/2021
 * @author Natalia Giraldo
 */
package ejercicios_encapsulamiento;

public class Password {
    
    //Constantes
    private final static int LONG_DEF = 8;
    //Atributos
    private int longitud;
    private String contraseña;

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    //Constructores
    //Contructor por defecto
    public Password(){
        this.longitud = LONG_DEF;
    }
    
    /**
     * La contraseña sera la pasada por parametro
     * @param longitud
     */
     public Password (int longitud){
        this.longitud=longitud;
        contraseña=generaPassword();
    }
    
    //Metodos públicos 
    public boolean esFuerte(){
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;
        //int cuentacharespecial = 0;
        
        //Vamos caracter a caracter y comprobamos que tipo de caracter es
        for (int i=0;i<contraseña.length();i++){
            if (contraseña.charAt(i)>=97 && contraseña.charAt(i)<=122){
                cuentaminusculas+=1;
            }else{
                if (contraseña.charAt(i)>=65 && contraseña.charAt(i)<=90){
                    cuentamayusculas+=1;
                }else{
                    cuentanumeros+=1;
                }
            }
        }
        //Si la constraseña tiene mas de 5 numeros, mas de 1 minuscula y mas de 2 mayusculas
        if (cuentanumeros>=5 && cuentaminusculas>=1 && cuentamayusculas>=2){
            return true;
        }else{
            return false;
        }
    }//Fin del metodo esFuerte
    
    /**
     * Genera una contraseña al azar con la longitud que este definida
     * @return contraseña
     */
    public String generaPassword (){
        String password="";
        for (int i=0;i<longitud;i++){
            //Generamos un numero aleatorio, segun este elige si añadir una
            //minuscula, mayuscula o numero
            int eleccion=((int)Math.floor(Math.random()*3+1));
  
            if (eleccion==1){
                char minusculas=(char)((int)Math.floor(Math.random()*(123-97)+97));
                password+=minusculas;
            }else{
                if(eleccion==2){
                    char mayusculas=(char)((int)Math.floor(Math.random()*(91-65)+65));
                    password+=mayusculas;
                }else{
                    char numeros=(char)((int)Math.floor(Math.random()*(58-48)+48));
                    password+=numeros;
                }
            }
        }
        return password;
    }//Fin del metodo generaPassword
}//Fin de la clase Password
