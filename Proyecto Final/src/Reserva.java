import java.util.Date;

public class Reserva {
    private static int numeroReserva=0;
    private ClientePreferencial cliente;
    private Mesa mesaReserva;
    private Date fecha;

    public Reserva (ClientePreferencial cliente, Mesa mesaReserva, Date fecha){
        this.cliente = cliente;
        this.mesaReserva = mesaReserva;
        this.fecha = fecha;
        numeroReserva++;
    }

    public void setNumeroReserva(int numeroReserva) {
        Reserva.numeroReserva = numeroReserva;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setCliente(ClientePreferencial cliente) {
        this.cliente = cliente;
    }

    public ClientePreferencial getCliente() {
        return cliente;
    }

    public void setMesaReserva(Mesa mesaReserva) {
        this.mesaReserva = mesaReserva;
    }

    public Mesa getMesaReserva() {
        return mesaReserva;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }
}
