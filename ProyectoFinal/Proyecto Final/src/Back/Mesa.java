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

import Back.GestorRestaurante;
import Back.ClientePreferencial;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mesa implements Serializable {
    private int numeroMesa;
    private String estado;
    private Pedido pedidoMesa;
    private ClientePreferencial cliente; //Puede ser null si no hay un cliente preferencial en la mesa


    public Mesa (int numeroMesa, Pedido pedidoMesa, ClientePreferencial cliente){
        this.numeroMesa = numeroMesa;
        this.estado = "Ocupada";
        this.pedidoMesa = pedidoMesa;
        this.cliente = cliente;
    }
    
    public Mesa (int numeroMesa, Pedido pedidoMesa){
        this.numeroMesa = numeroMesa;
        this.pedidoMesa = pedidoMesa;
        this.estado = "Ocupada";
        this.cliente = null;
    }
    
    public Mesa (int numeroMesa){
       this.numeroMesa = numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setPedidoMesa(Pedido pedidoMesa) {
        this.pedidoMesa = pedidoMesa;
    }

    public Pedido getPedidoMesa() {
        return pedidoMesa;
    }

    public void setCliente(ClientePreferencial cliente) {
        this.cliente = cliente;
    }

    public ClientePreferencial getCliente() {
        return cliente;
    }
    
    

    @Override
    public String toString() {
        return "Mesa No: " + numeroMesa + " ; Pedido" +
                pedidoMesa;
    }
    
    
    // Método para escribir elementos Mesa en un archivo binario
public static void escribirBinario(ArrayList<Mesa> elemento) {
    String ruta = "Mesas.bin";
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

// Método para leer elementos Mesa desde un archivo binario
public static ArrayList<Mesa> listarBinario() {
    String ruta = "Mesas.bin";
    // Verifica si el archivo binario existe, si no existe, crea uno nuevo
    if (!GestorRestaurante.existeBinario(ruta)) {
        GestorRestaurante.crearArchivo(ruta);
    }
    ArrayList<Mesa> listaProductos = new ArrayList<>();
    try {
        // Lee del archivo binario los elementos guardados y los almacena en la lista
        FileInputStream f = new FileInputStream(ruta);
        ObjectInputStream file = new ObjectInputStream(f);
        listaProductos = (ArrayList<Mesa>) file.readObject();
        file.close();
        f.close();

    } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    return listaProductos;
}

    // Método para buscar una mesa en el archivo binario por número de mesa
    public static Mesa buscarBinario(int numeroMesa) {
        String ruta = "Mesas.bin";
        // Verifica si el archivo binario existe, si no existe, crea uno nuevo
        if (!GestorRestaurante.existeBinario(ruta)) {
            GestorRestaurante.crearArchivo(ruta);
        }
        ArrayList<Mesa> listaPedidos = listarBinario();
        Mesa resultados = null;
        for (Mesa e : listaPedidos) {
            if (e != null) {
                if (e.getNumeroMesa() == numeroMesa) {
                    resultados = e;
                    break;
                }
            }
        }
        return resultados;
    }

    // Método para borrar una mesa del archivo binario por número de mesa
    public static void borrarBinario(int numeroMesa) {
        int i = 0;
        String ruta = "Mesas.bin";
        // Verifica si el archivo binario existe, si no existe, crea uno nuevo
        if (!GestorRestaurante.existeBinario(ruta)) {
            GestorRestaurante.crearArchivo(ruta);
        }
        ArrayList<Mesa> listaPedidos;
        // Si se encuentra la mesa por número
        if ((buscarBinario(numeroMesa)) != null) {
            listaPedidos = listarBinario();
            // Busca el índice de la mesa
            for (Mesa p : listaPedidos) {
                if (p.getNumeroMesa() == numeroMesa) {
                    break;
                }
                i++;
            }
            // Remueve la mesa del arreglo por su índice
            listaPedidos.remove(i);
            Mesa.escribirBinario(listaPedidos);
            JOptionPane.showMessageDialog(null, "Se ha eliminado la mesa");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la mesa");
        }
    }

}
