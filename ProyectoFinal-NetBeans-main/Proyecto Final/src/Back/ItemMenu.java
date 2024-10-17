package Back;

import java.io.Serializable;

public abstract class ItemMenu implements Serializable {
    protected String nombre;
    protected double precio;
    protected boolean disponible=true; //Siempre hay disponibilidad a menos que se cambie.
    
    public ItemMenu(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public String toString (){
        return "Nombre: " + nombre + "\n" + " ; Precio: " + precio + "\n"
                + " ; Disponibilidad: " + disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean getDisponible() {
        return disponible;
    }

}
