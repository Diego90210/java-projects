public class Mesa {
    private int numeroMesa;
    private String estado;
    private Pedido pedidoMesa;
    private ClientePreferencial cliente; //Puede ser null si no hay un cliente preferencial en la mesa


    public Mesa (int numeroMesa, String estado, Pedido pedidoMesa, ClientePreferencial cliente){
        this.numeroMesa = numeroMesa;
        this.estado = estado;
        this.pedidoMesa = pedidoMesa;
        this.cliente = cliente;
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

}
