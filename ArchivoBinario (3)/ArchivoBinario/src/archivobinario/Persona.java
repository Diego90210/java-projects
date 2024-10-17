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
public class Persona implements Serializable {
    protected String nombre;
    protected int cedula;

    public Persona() {
    }
    
    public Persona(String nombre, int cedula){
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }
   
    @Override
    public String toString(){
        return nombre+ " "+ cedula;
    }
}
