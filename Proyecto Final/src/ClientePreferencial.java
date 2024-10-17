public class ClientePreferencial{
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
                "No. Tarjeta: " + getTarjetaCliente() + "\n" +
                "Descuento: " + getDescuento();
    }

}
