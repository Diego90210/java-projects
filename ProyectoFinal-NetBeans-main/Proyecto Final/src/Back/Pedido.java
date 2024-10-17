package Back;

import Back.GestorRestaurante;
import Back.ItemPedido;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Pedido implements Serializable {
    private ArrayList <ItemPedido> items;
    private double total;
    private static int numeroPedido=0;

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
    
    
    public Pedido (ArrayList <ItemPedido> items){
        this.items = items;
        this.numeroPedido++;
    }
    
    public Pedido (){
        
    }
    
    
    @Override
    public String toString(){
        
        return "\nNumero de pedido: " + numeroPedido + "\n ; Ttotal"
                + total;
    }
    
    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPedido> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
   // Método para escribir elementos Pedido en un archivo binario
public static void escribirBinario(ArrayList<Pedido> elemento) {
    String ruta = "Pedidos.bin";
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

    // Método para leer elementos Pedido desde un archivo binario
    public static ArrayList<Pedido> listarBinario() {
        String ruta = "Pedidos.bin";
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        try {
            // Lee del archivo binario los elementos guardados y los almacena en la lista
            FileInputStream f = new FileInputStream(ruta);
            ObjectInputStream file = new ObjectInputStream(f);
            listaPedidos = (ArrayList<Pedido>) file.readObject();
            file.close();
            f.close();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaPedidos;
    }

    // Método para buscar un pedido en el archivo binario por número de pedido
    public static Pedido buscarBinario(int numeroPedido) {
        String ruta = "Pedidos.bin";
        ArrayList<Pedido> listaPedidos = listarBinario();
        Pedido resultados = null;
        for (Pedido e : listaPedidos) {
            if (e != null) {
                if (numeroPedido == e.getNumeroPedido()) {
                    resultados = e;
                    break;
                }
            }
        }
        return resultados;
    }

    // Método para borrar un pedido del archivo binario por número de pedido
    public static void borrarBinario(int numeroPedido) {
        int i = 0;
        String ruta = "Pedidos.bin";
        ArrayList<Pedido> listaPedidos;
        // Si se encuentra el pedido por número
        if ((buscarBinario(numeroPedido)) != null) {
            listaPedidos = listarBinario();
            // Busca el índice del pedido
            for (Pedido p : listaPedidos) {
                if (numeroPedido == p.getNumeroPedido()) {
                    break;
                }
                i++;
            }
            // Remueve el pedido del arreglo por su índice
            listaPedidos.remove(i);
            Pedido.escribirBinario(listaPedidos);
            JOptionPane.showMessageDialog(null, "Se ha eliminado el item del pedido");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el item");
        }
    }

}
