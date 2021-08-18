/**
 * Ejercicio 2
 * https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-programacion-orientado-a-objetos-java/
 * Creation date: 04/08/2021
 * Last modified date: 04/08/2021
 * @author Natalia Giraldo
 */

package ejercicios_encapsulamiento;

public class Persona {
    
    //Constantes
    private final static char SEXO_DEF = 'H';
    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;
    
    //Atributos
    private char sexo;
    private double peso;
    private double altura;
    private String nombre;
    private int edad;
    private String DNI;

    //Metodos set y get
    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //Constructores
    //Contructor por defecto
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_DEF;
        this.peso = 0;
        this.altura = 0;
    }
    
    /**
     * Constructor con 3 parametroe
     *
     * @param nombre de la persona
     * @param edad de la persona
     * @param sexo de la persona
     */
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
        generarDni();
    }
    
    /**
     * Constructor con 5 parametros
     *
     * @param nombre de la persona
     * @param edad de la persona
     * @param sexo de la persona
     * @param peso de la persona
     * @param altura de la persona
     */
    
    public Persona(String nombre, int edad, char sexo, double peso,
            double altura)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        generarDni();
        this.sexo = sexo;
        comprobarSexo();
    }
    
    //Metodos públicos 
    
    /**
     * Calcula el indice de masa corporal
     *
     * @return codigo numerico
     * <ul><li>-1: la persona esta por debajo de su peso ideal</li>
     * <li>0: la persona esta en su peso ideal</li>
     * <li>1: la persona esta por encima de su peso ideal</li></ul>
     */
    public int calcularIMC(){
        //Calculamos el peso de la persona
        double pesoActual = peso / (Math.pow(altura, 2));
        //Segun el peso, devuelve un codigo
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }//Fin del metodo calcularIMC
    
    /**
     * Indica si la persona es mayor de edad
     *
     * @return true si es mayor de edad y false es menor de edad
     */
    public boolean esMayorDeEdad(){
        boolean mayor = false;
        if (edad >= 18){
            mayor = true;
        }
        return mayor;
    }//Fin del metodo esMayorDeEdad
    
    /**
     * Devuelve informacion del objeto
     *
     * @return cadena con toda la informacion
     */
    @Override
    public String toString() {
        String sexo;
        if (this.sexo == 'H') {
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion de la persona:\n"
                + "Nombre: " + nombre + "\n"
                + "Sexo: " + sexo + "\n"
                + "Edad: " + edad + " años\n"
                + "DNI: " + DNI + "\n"
                + "Peso: " + peso + " kg\n"
                + "Altura: " + altura + " metros\n";
    }//Fin del metodo toString
    
    //Metodos privados
    private void comprobarSexo(){
        //Si el sexo no es una H o una M, por defecto es H
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_DEF;
        }
    }//Fin del metodo comprobarSexo
    
    private void generarDni(){
        final int DIVISOR = 23;
        
        //Generamos un número de 8 digitos
        int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
        int res = numDNI - (numDNI / DIVISOR * DIVISOR);
        
        //Calculamos la letra del DNI
        char letraDNI = generaLetraDNI(res);
        
        //Pasamos el DNI a String
        DNI = Integer.toString(numDNI) + letraDNI;
    }//Fin del metodo generarDni
    
    private char generaLetraDNI(int res) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
        return letras[res];
    } //Fin del metodo generaLetraDNI
}//Fin de la clase Persona
