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

import Back.ItemMenu;
import Back.GestorRestaurante;
import java.io.File;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;




public class Producto extends ItemMenu implements Serializable {
    public Producto (String nombre, double precio){
        super(nombre, precio);
    }

    
    // Método para escribir elementos Producto en un archivo binario
public static void escribirBinario(ArrayList<Producto> elemento) {
    String ruta = "Productos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    try {
        // Escribe en el archivo binario los elementos recibidos
        FileOutputStream f = new FileOutputStream(ruta);
        ObjectOutputStream file = new ObjectOutputStream(f);
        file.writeObject(elemento);
        file.close();
        f.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Método para leer elementos Producto desde un archivo binario
public static ArrayList<Producto> listarBinario() {
    String ruta = "Productos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    ArrayList<Producto> listaProductos = new ArrayList<>();
    try {
        // Lee del archivo binario los elementos guardados y los almacena en la lista
        FileInputStream f = new FileInputStream(ruta);
        ObjectInputStream file = new ObjectInputStream(f);
        listaProductos = (ArrayList<Producto>) file.readObject();
        file.close();
        f.close();

    } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    return listaProductos;
}

// Método para buscar un producto en el archivo binario por nombre
public static Producto buscarBinario(String nombre) {
    String ruta = "Productos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    ArrayList<Producto> listaProductos = listarBinario();
    Producto resultados = null;
    for (Producto e : listaProductos) {
        if ((e != null) && (e.getDisponible())) {
            if (nombre.toLowerCase().equals(e.getNombre().toLowerCase())) {
                resultados = e;
                break;
            }
        }
    }
    return resultados;
}

// Método para borrar un producto del archivo binario por nombre
public static void borrarBinario(String nombre) {
    int i = 0;
    String ruta = "Productos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }

    ArrayList<Producto> listaProductos;
    // Si se encuentra el producto por nombre
    if ((buscarBinario(nombre)) != null) {
        listaProductos = listarBinario();
        // Busca el índice del producto
        for (Producto p : listaProductos) {
            if (nombre.toLowerCase().equals(p.getNombre().toLowerCase())) {
                break;
            }
            i++;
        }
        // Remueve el producto del arreglo por su índice
        listaProductos.remove(i);
        Producto.escribirBinario(listaProductos);
        JOptionPane.showMessageDialog(null, "Se ha eliminado el producto");
    } else {
        JOptionPane.showMessageDialog(null, "No se ha encontrado el producto");
    }
}


}
