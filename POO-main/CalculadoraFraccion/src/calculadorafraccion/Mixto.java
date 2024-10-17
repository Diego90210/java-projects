/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafraccion;

/**
 *
 * @author Amaury
 */
public class Mixto {
    private int parteEntera;
    private Fraccion f;
    
    /**
    * Constructor por defecto no recibe parámetros crea 
    * el Mixto por defecto 1 0/1 
    */
    public Mixto(){
        parteEntera = 1;
        f = new Fraccion ();
    }
    
    /**
    * Constructor alternativo recibe como parámetros pent y la fraccion f,
    * inicializa los atributos con los valores de los parámetros 
    */
    public Mixto(int Pent, Fraccion f){
        parteEntera = Pent;
        this.f=f;  
    }
    
    /**
    * Constructor alternativo recibe como parámetros pent y los enteros 
    * num y den inicializa los atributos con los valores de los parámetros 
    * creando una fracción con los parametros num y den
    */
    public Mixto(int Pent, int num, int den){
        parteEntera = Pent;
        f = new Fraccion(num,den);
    }

    

    public void setParteEntera(int parteEntera) {
        this.parteEntera = parteEntera;
    }
    
    public void setF(Fraccion f) {
        this.f = f;
    }

    public Fraccion getF() {
        return f;
    }
    public int getParteEntera() {
        return parteEntera;
    }
    
    @Override
    public String toString() {
        return parteEntera+""+f.toString(); //3 1/2
    }
        
}
