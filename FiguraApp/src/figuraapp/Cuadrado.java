/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuraapp;

/**
 *
 * @author Estudiante
 */
public class Cuadrado extends Figura {
    private int lado;
    
    public Cuadrado(){
        super(); //Llamar al constructor de la super clase.
        lado = 1;
    }
    
    public int getLado (){
        return lado;
    }
    
    public void setLado (int lado){
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado*lado;
    }

    @Override
    public String toString() {
        return super.toString() + ", es un cuadrado." +
                " Y su area es = " + area();
    }
    
    @Override
    public void dibuja() {
        super.dibuja(); //Tiene su propio toString.
        System.out.println (" Un cuadrado");
    }
    
    @Override
    public void borra() {
        super.borra();//Tiene su propio toString.
        System.out.println (" Un cuadrado");
    }

}
