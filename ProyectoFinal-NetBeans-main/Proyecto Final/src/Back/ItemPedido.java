package Back;

import Back.GestorRestaurante;
import Back.ItemMenu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemPedido implements Serializable{
    private ItemMenu itemPed;
    private int cantidad;
    
    public ItemPedido (ItemMenu itemPed, int cantidad){
        this.itemPed = itemPed;
        this.cantidad = cantidad;
    }

    public ItemMenu getItemPed() {
        return itemPed;
    }

    public void setItemPed(ItemMenu itemPed) {
        this.itemPed = itemPed;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    @Override
    public String toString (){
        return "\nNombre item: " + itemPed.getNombre() +
                "\n ; Cantidad: " + cantidad;
    }
    
   // Método para escribir elementos en un archivo binario
    public static void escribirBinario(ArrayList<ItemPedido> elemento) {
        String ruta = "ItemsPedido.bin";
        // Verifica si el archivo binario existe, si no existe, crea uno nuevo
        if (!GestorRestaurante.existeBinario(ruta)) {
            GestorRestaurante.crearArchivo(ruta);
        }
        try {
            // Escribe en el archivo binario los elementos recibidos
            FileOutputStream f = new FileOutputStream(ruta);
            java.io.ObjectOutputStream file = new java.io.ObjectOutputStream(f);
            file.writeObject(elemento);
            file.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer elementos desde un archivo binario
    public static ArrayList<ItemPedido> listarBinario() {
        String ruta = "ItemsPedido.bin";
        ArrayList<ItemPedido> listaProductos = new ArrayList<>();
        try {
            // Lee del archivo binario los elementos guardados y los almacena en la lista
            FileInputStream f = new FileInputStream(ruta);
            ObjectInputStream file = new ObjectInputStream(f);
            listaProductos = (ArrayList<ItemPedido>) file.readObject();
            file.close();
            f.close();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

    // Método para buscar un item en el archivo binario por nombre
    public static ItemPedido buscarBinario(String nombre) {
        String ruta = "ItemsPedido.bin";
        ArrayList<ItemPedido> listaPedidos = listarBinario();
        ItemPedido resultados = null;
        for (ItemPedido e : listaPedidos) {
            if (e != null) {
                if (nombre.toLowerCase().equals(e.getItemPed().getNombre().toLowerCase())) {
                    resultados = e;
                    break;
                }
            }
        }
        return resultados;
    }

    // Método para borrar un item del archivo binario por nombre
    public static void borrarBinario(String nombre) {
        int i = 0;
        String ruta = "ItemsPedido.bin";

        ArrayList<ItemPedido> listaPedidos;
        // Si se encuentra el item por nombre
        if ((buscarBinario(nombre)) != null) {
            listaPedidos = listarBinario();
            // Busca el índice del item
            for (ItemPedido p : listaPedidos) {
                if (nombre.toLowerCase().equals(p.getItemPed().getNombre().toLowerCase())) {
                    break;
                }
                i++;
            }
            // Remueve el item del arreglo por su índice
            listaPedidos.remove(i);
            ItemPedido.escribirBinario(listaPedidos);
            JOptionPane.showMessageDialog(null, "Se ha eliminado el item del pedido");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el item");
        }
    }

    
}
