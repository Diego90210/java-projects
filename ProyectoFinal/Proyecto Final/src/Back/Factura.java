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

import Back.ClientePreferencial;
import java.io.Serializable;

public class Factura implements Serializable {
    private static int numeroFactura = 0;
    private ClientePreferencial cliente;
    private Pedido pedidoFactura;
    private double impuestos;
    private double totalAPagar;

    public Factura (ClientePreferencial cliente, Pedido pedidoFactura, double impuestos, double totalAPagar){
        this.cliente = cliente;
        this.pedidoFactura = pedidoFactura;
        this.impuestos = impuestos;
        this.totalAPagar = totalAPagar;
        numeroFactura++;
    }

    @Override
    public String toString(){
        return "Total a pagar: " + totalAPagar;
    }
    
    public void setNumeroFactura(int numeroFactura) {
        Factura.numeroFactura = numeroFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setCliente(ClientePreferencial cliente) {
        this.cliente = cliente;
    }

    public ClientePreferencial getCliente() {
        return cliente;
    }

    public void setPedidoFactura(Pedido pedidoFactura) {
        this.pedidoFactura = pedidoFactura;
    }

    public Pedido getPedidoFactura() {
        return pedidoFactura;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

}
