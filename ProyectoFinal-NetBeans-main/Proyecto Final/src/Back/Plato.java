package Back;

import Back.ItemMenu;
import Back.GestorRestaurante;
import java.io.EOFException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;



public class Plato extends ItemMenu implements  Serializable{
    public Plato (String nombre, double precio){
        super(nombre, precio);
    }
    
    
    // Método para escribir elementos Plato en un archivo binario
public static void escribirBinario(ArrayList<Plato> elemento) {
    String ruta = "Platos.bin";
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

// Método para leer elementos Plato desde un archivo binario
public static ArrayList<Plato> listarBinario() {
    String ruta = "Platos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    ArrayList<Plato> listaPlatos = new ArrayList<>();
    try {
        // Lee del archivo binario los elementos guardados y los almacena en la lista
        FileInputStream f = new FileInputStream(ruta);
        ObjectInputStream file = new ObjectInputStream(f);
        listaPlatos = (ArrayList<Plato>) file.readObject();
        file.close();
        f.close();

    } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    return listaPlatos;
}

// Método para buscar un plato en el archivo binario por nombre
public static Plato buscarBinario(String nombre) {
    String ruta = "Platos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    ArrayList<Plato> listaPlatos = listarBinario();
    Plato resultados = null;
    for (Plato e : listaPlatos) {
        if (e != null && (e.getDisponible())) {
            if (nombre.toLowerCase().equals(e.getNombre().toLowerCase())) {
                resultados = e;
                break;
            }
        }
    }
    return resultados;
}

// Método para borrar un plato del archivo binario por nombre
public static void borrarBinario(String nombre) {
    int i = 0;
    String ruta = "Platos.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    ArrayList<Plato> listaPlatos;
    // Si se encuentra el plato por nombre
    if ((buscarBinario(nombre)) != null) {
        listaPlatos = listarBinario();
        // Busca el índice del plato
        for (Plato p : listaPlatos) {
            if (nombre.toLowerCase().equals(p.getNombre().toLowerCase())) {
                break;
            }
            i++;
        }
        // Remueve el plato del arreglo por su índice
        listaPlatos.remove(i);
        Plato.escribirBinario(listaPlatos);
        JOptionPane.showMessageDialog(null, "Se ha eliminado el plato");
    } else {
        JOptionPane.showMessageDialog(null, "No se ha encontrado el plato");
    }
}

    
}

   
    

