/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivobinario;

import java.io.Serializable;
/**
 *
 * @author Amaury
 */
public class Estudiante extends Persona  implements Serializable{
    
    protected int codigo;
    protected float promedio;
    //Esta variable es para identificar el archivo cuando lo vayamos a reconstruir del *.DAT
    
    
    public Estudiante(){
        
    }
    
    public Estudiante(String nombre, int cedula, int codigo, float promedio){
          this.nombre = nombre;
          this.cedula = cedula;
          this.codigo = codigo;
          this.promedio = promedio;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    
    @Override
    public String toString(){        
        return  super.toString()+" "+codigo+" "+promedio+" ";
    }
    
    
    
}
