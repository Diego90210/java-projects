package Back;

import static Back.Mesa.listarBinario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ClientePreferencial implements Serializable{
    private String nombre;
    private int tarjetaCliente;
    private double descuento;

    public ClientePreferencial(String nombre, int tarjetaCliente, double descuento){
        this.nombre = nombre;
        this.tarjetaCliente = tarjetaCliente;
        this.descuento = descuento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTarjetaCliente(int tarjetaCliente) {
        this.tarjetaCliente = tarjetaCliente;
    }

    public int getTarjetaCliente() {
        return tarjetaCliente;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return "Nombre: "+getNombre() + "\n" +
                " ; No. Tarjeta: " + getTarjetaCliente() + "\n" +
                " ; Descuento: " + getDescuento();
    }
    
        // Método para escribir datos en un archivo binario
    public static void escribirBinario(ArrayList<ClientePreferencial> elemento) {
        // Ruta del archivo binario
        String ruta = "Clientes.bin";

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

    // Método para leer datos desde un archivo binario
    public static ArrayList<ClientePreferencial> listarBinario() {
        // Ruta del archivo binario
        String ruta = "Clientes.bin";

        // Verifica si el archivo binario existe, si no existe, crea uno nuevo
        if (!GestorRestaurante.existeBinario(ruta)) {
            GestorRestaurante.crearArchivo(ruta);
        }

        ArrayList<ClientePreferencial> listaClientes = new ArrayList<>();
        try {
            // Lee del archivo binario los elementos guardados y los almacena en la lista
            FileInputStream f = new FileInputStream(ruta);
            ObjectInputStream file = new ObjectInputStream(f);
            listaClientes = (ArrayList<ClientePreferencial>) file.readObject();
            file.close();
            f.close();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    // Método para buscar un cliente en el archivo binario por número de tarjeta
    public static ClientePreferencial buscarBinario(int numeroTarjeta) {
        // Ruta del archivo binario
        String ruta = "Mesas.bin";

        // Verifica si el archivo binario existe, si no existe, crea uno nuevo
        if (!GestorRestaurante.existeBinario(ruta)) {
            GestorRestaurante.crearArchivo(ruta);
        }

        // Obtiene la lista de clientes desde el archivo binario
        ArrayList<ClientePreferencial> listaClientes = listarBinario();
        ClientePreferencial resultados = null;

        // Itera sobre la lista de clientes para buscar el número de tarjeta especificado
        for (ClientePreferencial e : listaClientes) {
            if (e != null) {
                if (e.getTarjetaCliente() == numeroTarjeta) {
                    resultados = e;
                    break;
                }
            }
        }
        return resultados;
    }

    
}
