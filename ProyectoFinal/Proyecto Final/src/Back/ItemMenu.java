/************************************************************************
Palabra de honor:
* No he discutido ni mostrado el código de mi programa con alguien que no sea mi compañero,
* Profesor o con el monitor asignado a este curso.
*
* No he utilizado código obtenido de otro u otros estudiantes,
* O cualquier otra fuente no autorizada, ya sea modificado o sin modificar.
*
* Si cualquier código o documentación utilizada en mi programa
* Fue obtenido de otra fuente, tal como un libro de texto o notas del curso
* debe ser claramente señalado con una cita apropiada en
* los comentarios de mi programa.
*
* &lt;Diego Andrés Martínez Florez – 0222120002; *
***********************************************************************/
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
