/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuraapp;

/**
 *
 * @author Estudiante
 */
public abstract class Figura {
    private static final int 
                       ROJO = 1,
                       VERDE = 2,
                       AZUL = 3;
    
    protected int color;
    
    public Figura (){
        color = ROJO;
    }
    
    public Figura (int color){
        this.color = color;
    }
    
    public void setColor (int color){
        this.color = color;
    }
    
    public int getColor (){
        return color;
    }

    public abstract double area();

    private String identiColor (int color){
        if (color == 1){
            return "rojo";
        } else if (color == 2) {
            return "verde";
        }
        return "azul";
    }

    @Override
    public String toString (){
        return "La figura es de color "+identiColor(color);
    }
    
    public void dibuja(){
        System.out.println("Dibuja Figura");
    }
    
    public void borra(){
        System.out.println("Borra Figura");
    }
    
} //End class.
