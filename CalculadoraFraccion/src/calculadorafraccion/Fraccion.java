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
public class Fraccion {
    private int num;
    private int den;
    
    /**
    * Constructor por defecto no recibe parámetros crea 
    * fracción por defecto 0/1 
    */
    public Fraccion(){
        this.num = 0;
        this.den = 1;
    }
    
    /**
    * Constructor alternativo recibe como parámetros num y den,
    * inicializa los atributos con los valores de los parámetros 
    * el parametro den no puede ser cero 
    * En caso que den sea cero, se inicializan los atributos 
    * a la fraccion por defecto 0/1
    */

    public Fraccion(int num, int den){
        if (den==0)
        {
            this.num = 0;
            this.den = 1;
        }
        else
        {
            this.num = num;
            this.den = den;
            simplificar ();
        }
    }

    public void setDen(int den) {
        this.den = den;
    }

    public void setNum(int num) {
        this.num = num;
    }    

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }
    
    @Override
    public String toString() {
        return num+"/"+den; 
    }
    
    /* Metodo simplificar 
       Para simplificar una fracción primero hay que hallar 
       el mcd del numerador y del denominador. 
       Una vez hallado se divide el numerador y el denominador
       por este número
    */
    private void simplificar(){
        int mcd = mcd ();
        this.num /= mcd;
        this.den /= mcd;
    }
    
    /*
    Algoritmo de Euclides para calcular el MCD
    */
    private int mcd(){
      int u=Math.abs (num); 
      int v=Math.abs (den);
        if (v==0) {
            return u;
        } //end if
      int r;
        while (v!=0) {
            r=u%v;
            u=v;
            v=r;
        } //end while
      return u;
    } //end mcd 
}
