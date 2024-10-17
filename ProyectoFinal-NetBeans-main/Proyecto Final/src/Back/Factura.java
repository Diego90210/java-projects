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
