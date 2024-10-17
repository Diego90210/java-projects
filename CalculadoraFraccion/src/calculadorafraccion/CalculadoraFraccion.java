/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafraccion;

import javax.swing.JOptionPane;

/**
 *
 * @author Amaury
 */
public class CalculadoraFraccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fraccion f1 = new Fraccion(1,4);
        Fraccion f2 = new Fraccion(2,4);
        Fraccion f3 = new Fraccion();
        Fraccion f4 = new Fraccion (4,1);
        
        Fraccion suma = sumar(f1,f2);
        Fraccion resta = restar(f1,f3);
        Fraccion producto = multiplicar(f1,f4);
        Fraccion cociente = dividir (f1,f2);
        
        JOptionPane.showMessageDialog(null, f1+"+"+f2+"="+suma);
        JOptionPane.showMessageDialog(null, f1+"-"+f3+"="+resta);
        JOptionPane.showMessageDialog(null, f1+"*"+f4+"="+producto);
        JOptionPane.showMessageDialog(null, f1+"/"+f2+"="+cociente);
        /**********************/
        
        Mixto m1 = new Mixto (2,f1);
        Mixto m2 = new Mixto (3,1,4);
        Mixto m3 = new Mixto (1,f2);
        
        Mixto suma2 = sumar(m1,m2);
        
        //realice un menu, que permita ingresar un mixto o una fraccion
        //Y se escoja la operación a realizar, mostrando el resultado
        
    }
    
    /*Método convertir mixto a fraccion, recibe como parametro un
      Mixto y devuelve la fracción f, que corresponde al 
      numero mixto m1
    */
    public static Fraccion convertirMixtoFraccion(Mixto m1){
        Fraccion f=null;
        //ESCRIBA SU CÓDIGO AQUI
        return f;
    } 
    
    /*Método sumar fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fracción f3, con el resultado de 
      la suma. f3 = f1+f2
    */
    public static Fraccion sumar(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        return f3;
    }
    
    /*Método sumar mixtos, recibe como parametros dos
      mixtos m1 y m2 y devuelve el mixto m3, con el resultado de 
      la suma. m3 = m1+m2
    */
    public static Mixto sumar(Mixto m1, Mixto m2){
        Mixto m3=null;
        //ESCRIBA SU CÓDIGO AQUI
        return m3;
    }
    
    /*Método restar fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fraccion f3, con el resultado de 
      la resta. f3 = f1-f2
    */
    public static Fraccion restar(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        return f3;
    }
    
    public static Mixto restar(Mixto m1, Mixto m2){
        Mixto m3=null;
        //ESCRIBA SU CÓDIGO AQUI
        return m3;
    }
    
    /*Método multiplicar fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fraccion f3, con el resultado de 
      la multiplicación. f3 = f1*f2
    */
    public static Fraccion multiplicar(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        return f3;
    }
    
    /*Método dividir fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fraccion f3, con el resultado de 
      la división. f3 = f1*f2
    */
    public static Fraccion dividir(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        return f3;
    }
    
    
    
}
