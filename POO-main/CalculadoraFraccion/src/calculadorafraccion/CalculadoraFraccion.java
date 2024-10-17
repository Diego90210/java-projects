/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafraccion;

import javax.swing.JOptionPane;
import java.util.Scanner;
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
        int op, ente, nume, deno;
        Mixto mxto1, mxto2;
        Fraccion frcn1, frcn2;
        Object [] resultado = new Object[2];
        
        
        Scanner s = new Scanner (System.in); 
        do{
            System.out.println("\nMenú de Operaciones:");
            System.out.println("1. Ingresar dos fracciones.");
            System.out.println("2. Ingresar dos mixtos.");
            System.out.println("3. Ingresar un mixto y una fracción.");
            System.out.println("4. Mostrar resultado de las dos últimas operaciones.");
            System.out.println("5. Salir.");
            System.out.print("Seleccione una opción: ");
            op = s.nextInt();

            switch (op)
            {
                case 1:
                    System.out.println("\nFracción 1");
                    System.out.print("Numerador: ");
                    nume = s.nextInt();
                    System.out.print("Denominador: ");
                    deno = s.nextInt();

                    frcn1 = new Fraccion (nume, deno);

                    System.out.println("\nFracción 2");
                    System.out.print("Numerador: ");
                    nume = s.nextInt();
                    System.out.print("Denominador: ");
                    deno = s.nextInt();

                    frcn2 = new Fraccion (nume, deno); 

                    op = menuOperacionesF();
                    switch (op)
                    {
                        case 1: System.out.println ("Resultado: " + sumar(frcn1, frcn2));
                        break;
                        case 2: System.out.println ("Resultado: " + restar(frcn1, frcn2));
                        break;
                        case 3: System.out.println ("Resultado: " + multiplicar(frcn1, frcn2));
                        break;
                        case 4: System.out.println ("Resultado: " + dividir(frcn1, frcn2));
                    }
                break;

                case 2:
                    System.out.println("Mixto 1");
                    System.out.print("Parte entera: ");
                    ente = s.nextInt();
                    System.out.print("Numerador: ");
                    nume = s.nextInt();
                    System.out.print("Denominador: ");
                    deno = s.nextInt();

                    mxto1 = new Mixto (ente, nume, deno);

                    System.out.println("Mixto 2");
                    System.out.print("Parte entera: ");
                    ente = s.nextInt();
                    System.out.print("Numerador: ");
                    nume = s.nextInt();
                    System.out.print("Denominador: ");
                    deno = s.nextInt();

                    mxto2 = new Mixto (ente, nume, deno);

                    op = menuOperacionesM();

                    switch (op)
                    {
                        case 1: System.out.println ("Resultado: " + sumar(mxto1, mxto2));
                        break;
                        case 2: System.out.println ("Resultado: " + restar(mxto1, mxto2));
                    }

                break;

                case 3:
                    System.out.println("Mixto");
                    System.out.print("Parte entera: ");
                    ente = s.nextInt();
                    System.out.print("Numerador: ");
                    nume = s.nextInt();
                    System.out.print("Denominador: ");
                    deno = s.nextInt();

                    mxto1 = new Mixto (ente, nume, deno);
                    frcn1 = convertirMixtoFraccion(mxto1);

                    System.out.println("\nFracción");
                    System.out.print("Numerador: ");
                    nume = s.nextInt();
                    System.out.print("Denominador: ");
                    deno = s.nextInt();

                    frcn2 = new Fraccion (nume, deno);

                    op = menuOperacionesF();

                    switch (op)
                    {
                        case 1: System.out.println ("Resultado: " + sumar(frcn1, frcn2));
                        break;
                        case 2: 
                                System.out.println("\n1. Restar fracción a mixto");
                                System.out.println("2. Restar mixto a fracción");
                                System.out.print("Seleccione una opción: ");
                                op = s.nextInt();

                                if (op==1)
                                {
                                    System.out.println ("Resultado: " + restar(frcn1, frcn2));
                                }
                                else{
                                    System.out.println ("Resultado: " + restar(frcn2, frcn1));
                                }
                        break;

                        case 3:
                            System.out.println ("Resultado: " + multiplicar(frcn1, frcn2));
                        break;

                        case 4:
                            System.out.println("\n1. Dividir fracción entre mixto");
                            System.out.println("2. Dividir mixto entre fracción");
                            System.out.print("Seleccione una opción: ");
                            op = s.nextInt();

                            if (op==1)
                            {
                                System.out.println ("Resultado: " + dividir(frcn1, frcn2));
                            }
                            else{
                                System.out.println ("Resultado: " + dividir(frcn2, frcn1));
                            }
                    }
                break;

                case 4: //Método resultadosGuardados.
                break;

                case 5: System.exit(0);
            }
            pausa();
        }while(op!=5);  
    }
    
    /*Método convertir mixto a fraccion, recibe como parametro un
      Mixto y devuelve la fracción f, que corresponde al 
      numero mixto m1
    */
    public static Fraccion convertirMixtoFraccion(Mixto m1){
        Fraccion f=null;
        f = m1.getF();
        f.setNum(( (m1.getParteEntera()*f.getDen()) + f.getNum() ));
        return f;
    } 
    
    /*Método sumar fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fracción f3, con el resultado de 
      la suma. f3 = f1+f2
    */
    public static Fraccion sumar(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        int nume1, nume2, deno;
        f3 = new Fraccion();
        nume1 = ((f1.getNum()) * (f2.getDen()));
        nume2 = ((f2.getNum()) * (f1.getDen()));
        deno = ((f1.getDen()) * (f2.getDen()));

        f3.setNum((nume1+nume2));
        f3.setDen(deno);

        return f3;
    }
    
    /*Método sumar mixtos, recibe como parametros dos
      mixtos m1 y m2 y devuelve el mixto m3, con el resultado de 
      la suma. m3 = m1+m2
    */
    public static Mixto sumar(Mixto m1, Mixto m2){
        Mixto m3=null;
        //ESCRIBA SU CÓDIGO AQUI
        int entera;
        Fraccion f1, f2, f3;
        f1 = convertirMixtoFraccion(m1);
        f2 = convertirMixtoFraccion(m2);

        f3 = sumar(f1, f2);
        entera = (m1.getParteEntera() + m2.getParteEntera());

        m3 = new Mixto(entera, f3);

        return m3;
    }
    
    /*Método restar fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fraccion f3, con el resultado de 
      la resta. f3 = f1-f2
    */
    public static Fraccion restar(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        int nume1, nume2, deno;
        f3 = new Fraccion();
        nume1 = ((f1.getNum()) * (f2.getDen()));
        nume2 = ((f2.getNum()) * (f1.getDen()));
        deno = ((f1.getDen()) * (f2.getDen()));

        f3.setNum((nume1-nume2));
        f3.setDen(deno);

        return f3;
    }
    
    public static Mixto restar(Mixto m1, Mixto m2){
        Mixto m3=null;
        //ESCRIBA SU CÓDIGO AQUI
        int entera;
        Fraccion f1, f2, f3;

        f1 = convertirMixtoFraccion(m1);
        f2 = convertirMixtoFraccion(m2);

        f3 = restar(f1, f2);

        entera = (m1.getParteEntera()) - (m2.getParteEntera());

        m3 = new Mixto(entera, f3);

        return m3;
    }
    
    /*Método multiplicar fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fraccion f3, con el resultado de 
      la multiplicación. f3 = f1*f2
    */
    public static Fraccion multiplicar(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        f3 = new Fraccion();
        f3.setNum((f1.getNum())*(f2.getNum()));
        f3.setDen((f1.getDen())*(f2.getDen()));
        return f3;
    }
    
    /*Método dividir fraccionarios, recibe como parametros dos
      fracciones f1 y f2 y devuelve la fraccion f3, con el resultado de 
      la división. f3 = f1*f2
    */
    public static Fraccion dividir(Fraccion f1, Fraccion f2){
        Fraccion f3=null;
        //ESCRIBA SU CÓDIGO AQUI
        f3 = new Fraccion();
        f3.setNum((f1.getNum())*(f2.getDen()));
        f3.setDen((f1.getDen())*(f2.getNum()));
        return f3;
    }
    
    public static int menuOperacionesF ()
    {
        Scanner s = new Scanner (System.in);
        int op;
        System.out.println("\n1. Sumar.");
        System.out.println("2. Restar.");
        System.out.println("3. Multiplicar.");
        System.out.println("4. Dividir.");
        System.out.print("Seleccione una opción: ");
        op = s.nextInt();
        return op;
    }
    
    public static int menuOperacionesM ()
    {
        Scanner s = new Scanner (System.in);
        int op;
        System.out.println("\n1. Sumar.");
        System.out.println("2. Restar.");
        System.out.print("Seleccione una opción: ");
        op = s.nextInt();
        return op;
    }
    
    //Obtenido de Stack Overflow. 
    public static void pausa()
    {
        System.out.println("\nPresione cualquier tecla para Continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
    
    
    
}
