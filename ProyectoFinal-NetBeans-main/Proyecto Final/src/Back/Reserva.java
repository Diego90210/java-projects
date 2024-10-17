package Back;

import Back.GestorRestaurante;
import Back.Mesa;
import Back.ClientePreferencial;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Reserva implements Serializable {
    private int numeroReserva;
    private ClientePreferencial cliente;
    private Mesa mesaReserva;
    private Calendar fecha;

    public Reserva (int numeroReserva, ClientePreferencial cliente, Mesa mesaReserva, String fecha){
        this.numeroReserva = numeroReserva;
        this.cliente = cliente;
        this.mesaReserva = mesaReserva;
        mesaReserva.setEstado("Ocupada");
        this.fecha = inicializarCalendar(fecha);
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
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

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getFecha() {
        return fecha;
    }
    
    public static Calendar inicializarCalendar(String fecha) {
        try {
            String[] partesFecha = fecha.split("/");
            int year = Integer.parseInt(partesFecha[0]);
            int month = Integer.parseInt(partesFecha[1]) - 1; // Restar 1 al mes porque en Calendar los meses van de 0 a 11
            int day = Integer.parseInt(partesFecha[2]);

            return new Calendar.Builder().setDate(year, month, day).build();
        } catch (NumberFormatException e) {
            System.out.println("Error al inicializar el Calendar con la fecha proporcionada.");
            return null;
        }
    }
    
    public static void escribirBinario(ArrayList <Reserva> elemento) {
        String ruta = "Reservas.bin";
        if (!GestorRestaurante.existeBinario(ruta)){
            GestorRestaurante.crearArchivo(ruta);
        }
        try{
            FileOutputStream f = new FileOutputStream(ruta);
            java.io.ObjectOutputStream file = new java.io.ObjectOutputStream(f);
            file.writeObject(elemento);
            file.close();
            f.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    
    public static ArrayList<Reserva> listarBinario() {
        String ruta = "Reservas.bin";
        if (!GestorRestaurante.existeBinario(ruta)){
            GestorRestaurante.crearArchivo(ruta);
        }
        ArrayList<Reserva> lista = new ArrayList<>();
        try{
            FileInputStream f = new FileInputStream(ruta);
            ObjectInputStream file = new ObjectInputStream (f);
            lista = (ArrayList<Reserva>) file.readObject();
            file.close();
            f.close();
        }
        catch (IOException | ClassNotFoundException ex){
             ex.printStackTrace();
        }
        return lista;
    }

    
    public static Reserva buscarBinario(int numeroReserva) {
        String ruta = "Reservas.bin";
        if (!GestorRestaurante.existeBinario(ruta)){
            GestorRestaurante.crearArchivo(ruta);
        }
        ArrayList<Reserva> lista = Reserva.listarBinario();
        Reserva resultados=null;
        for (Reserva e : lista) {
            if (e!=null){
                if ((e.getNumeroReserva()) == numeroReserva) {
                    resultados = e;
                    break;
                }
            } 
        }
        return resultados;
    }

    public static void borrarBinario(int numeroReserva) {
        int i=0;
        String ruta = "Reservas.bin";
        if (!GestorRestaurante.existeBinario(ruta)){
            GestorRestaurante.crearArchivo(ruta);
        }
        ArrayList <Reserva> lista;
        if ((buscarBinario(numeroReserva))!=null){
            lista = listarBinario();
            for (Reserva p: lista){
                if (p.getNumeroReserva() == numeroReserva){
                    break;
                }
                i++;
            }
            lista.remove(i);
            Reserva.escribirBinario(lista);
            JOptionPane.showMessageDialog(null, " Se ha eliminado la reserva");
        }
        else{
            JOptionPane.showMessageDialog(null, " No se ha encontrado la reserva");
        }
    }
    
    public static boolean verificarDisponibilidadMesa(Mesa mesa, Calendar fecha){
        ArrayList <Reserva> listaReservas = Reserva.listarBinario();
        for (Reserva re: listaReservas){
            //Si la mesa ya se encuentra en la lista de reservas.
            //Y si la fecha coincide con la de otra reserva.
            if ((mesa.equals(re.getMesaReserva()) && fecha.equals(re.getFecha()))){
                //La mesa no está disponible.
                return false;
            }
        }
        return true;
    }
    
    //Obtenido de StackOverFlow
    // Método para validar el formato de una fecha
    // Utiliza expresiones regulares para asegurar el formato 'AAAA/MM/DD'
    public static boolean validarFormatoFecha(String fecha) {
        String regex = "\\d{4}/\\d{2}/\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);

        return matcher.matches();
    }
    // Método para obtener una fecha formateada a partir de un objeto Calendar
    public static String obtenerFecha(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Suma 1 al mes para obtener el mes real
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day);
    }
    
}
