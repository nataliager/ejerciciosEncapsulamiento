/**
 * Ejercicio 1
 * https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-programacion-orientado-a-objetos-java/
 * Creation date: 04/08/2021
 * Last modified date: 04/08/2021
 * @author Natalia Giraldo
 */
package ejercicios_encapsulamiento;

public class Cuenta {
    
    //Atributos
    private String titular;
    private double cantidad;
    
    //Metodos set y get
    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    //Constructores
    public Cuenta(String titular){
        this.titular = titular;
    }
    
     public Cuenta(String titular, int cantidad){
        this.titular = titular;
        if (cantidad < 0){
            this.cantidad = 0;
        }else{
            this.cantidad = cantidad;
        }
    }
    
     /**
      * Ingresa dinero a la cuenta si el monto es positivo
      * @param cantidad 
     */
    public void ingresar(double cantidad){
        if (cantidad > 0){
            this.cantidad += cantidad;
            System.out.println("Saldo actual: " + cantidad);
        }else{
            System.out.println("Valor invalido");
        }
    }//Fin del metodo ingresar
    
    /**
      * Retira una cantidad en la cuenta, si la cuenta queda en negativos
      * quedaria en 0.
      * @param cantidad 
     */
    public void retirar(double cantidad){
        System.out.println("Saldo actual: "+this.cantidad);
        this.cantidad -= cantidad;
        System.out.println("Cantidad a retirar: "+cantidad);
        if (this.cantidad <= 0){
            this.cantidad = 0;
            System.out.println(this.cantidad);
        }else{
            System.out.println("Saldo actual: "+this.cantidad);
        }   
    }// Fin del metodo retirar  
    
    /**
     * Devuelve el estado del objeto
     *
     * @return
     */
    @Override
    public String toString(){
        return "El titular " + titular + " tiene $" + cantidad + " pesos en la"
                + " cuenta";
                
    }
}//Fin de la clase Cuenta.java
