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

import Back.Factura;
import Back.ClientePreferencial;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class GestorRestaurante implements Serializable {
   
    //Método estático que genera una factura a partir de una mesa.
    public static Factura generarFactura(Mesa mesaFactura){
        double totalPedido=0;
        double descuento=0;
        if (mesaFactura == null || mesaFactura.getPedidoMesa() == null){
            return null;
        }
        if (mesaFactura.getCliente()!=null){
            descuento = (calcularTotalPedido(mesaFactura.getPedidoMesa()))*((mesaFactura.getCliente().getDescuento())/100);
        }
        totalPedido = (calcularTotalPedido(mesaFactura.getPedidoMesa()))-descuento;
        //modificar el cálculo de impuestos luego.
        double impuestos = totalPedido*0.1;

        double totalAPagar = totalPedido + impuestos;

        return new Factura(mesaFactura.getCliente(), mesaFactura.getPedidoMesa(), impuestos, totalAPagar);
    }

    // Método estático que calcula el total de un pedido.
    public static double calcularTotalPedido (Pedido ped){
        ArrayList<ItemPedido> items = ped.getItems();
        double total = 0;

        for (ItemPedido item : items) {
            total += (item.getItemPed().getPrecio() * item.getCantidad());
        }
        return total;
    }
    //Método para comprobar la existencia de un archivo.
    public static boolean existeBinario(String ruta) {
        File f = new File (ruta);
        return f.exists();
    }
    
    public static void crearArchivo(String ruta) {
        try {
            File f = new File(ruta);
            if (f.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Archivo creado correctamente. ");
            } else {
                JOptionPane.showMessageDialog(null, " Abriendo archivo. ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
