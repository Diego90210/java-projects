import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class GestorRestaurante{
    private static ArrayList <Reserva> listaReservas;
    private static ArrayList <ClientePreferencial> clientesPreferenciales;

    public static void main(String[] args) {

    }

    //Método estático para crear un menú.
    public static Menu crearMenu (ArrayList <ItemMenu> itemsMenu){
        return new Menu(itemsMenu);
    }

    //Método estático que modifica los platos y productos de un menú.
    public static void modificarMenu(Menu men, ArrayList <ItemMenu> itemsMenu){
        men.setItemsMenu(itemsMenu);
    }

    //Método estático que retorna un Cliente preferencial.
    public static ClientePreferencial crearClientePreferencial(String nombre, int tarjetaCliente, double descuento){
        return new ClientePreferencial(nombre, tarjetaCliente, descuento);
    }

    //Método estático que muestra la lista de clientes preferenciales.
    public static void listarClientesPreferenciales(ArrayList <ClientePreferencial> clientesPreferenciales){
        for (ClientePreferencial cliente: clientesPreferenciales){
            System.out.println(cliente);
        }
    }

    //Método estático para gestionar un pedido en una mesa.
    public static void gestionarPedido (Mesa mesaPedido, ItemPedido item){
        //Verificar si la mesa está ocupada.
        if(!mesaPedido.getEstado().equals("Ocupada")){
            System.out.println("La mesa no está ocupada. No se puede gestionar el pedido.");
            return;
        }
        //Verificar si el pedido existe, si no, crear uno nuevo.
        if (mesaPedido.getPedidoMesa()==null){
            Pedido p = new Pedido();
            mesaPedido.setPedidoMesa(p);
        }
        //Agregar el ítem al pedido.
        mesaPedido.getPedidoMesa().getItems().add(item);

        //Calcular y Actualizar el total del pedido en la mesa.
        mesaPedido.getPedidoMesa().setTotal(calcularTotalPedido(mesaPedido.getPedidoMesa()));

    }

    //Método estático para gestionar una reserva.
    public static Reserva gestionarReserva(ClientePreferencial cliente, Mesa mesaReserva, Date fecha){
        //Verificar si la mesa está disponible para la fecha deseada.
        if (!verificarDisponibilidadMesa(mesaReserva, fecha)){
            return null;
        }
        //La mesa está disponible.
        mesaReserva.setEstado("Ocupada");
        return new Reserva(cliente, mesaReserva, fecha);
    }

    //Método estático que verifica la existencia de un cliente preferencial.
    public static boolean verificarClientePreferencial (int tarjetaCliente){
        for (ClientePreferencial cli: clientesPreferenciales){
            if (cli.getTarjetaCliente() == tarjetaCliente){
                return true;
            }
        }
        return false;
    }

    //Método estático que verifica la disponibilidad de una mesa.
    public static boolean verificarDisponibilidadMesa(Mesa mesa, Date fecha){
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

    //Método estático que modifica la disponibilidad de un producto o plato.
    public static void gestionarDisponibilidad (Menu men, String nombre, boolean disponible){
        for (ItemMenu item: men.getItemsMenu()){
            if (item.getNombre().equals(nombre)){
                item.setDisponible(disponible);
                return;
            }
        }
    }

    //Método estático que modifica la información de un cliente preferencial.
    public static void modificarClientePreferencial (int tarjeta, String nombre, double descuento){
        ClientePreferencial clienteEncontrado = null;
        //Itera sobre la lista de clientes preferenciales.
        for (ClientePreferencial c: clientesPreferenciales){
            // Comprueba si la tarjeta del cliente actual coincide con la tarjeta proporcionada.
            if (c.getTarjetaCliente() == tarjeta){
                clienteEncontrado = c;
                break;
            }
        }
        //Si el cliente fue encontrado se modifican sus atributos.
        if (clienteEncontrado != null){
            clienteEncontrado.setDescuento(descuento);
            clienteEncontrado.setNombre(nombre);
        }
        else{
            System.out.println("Cliente preferencial no encontrado.");
        }
    }

    //Método estático que genera una factura a partir de una mesa.
    public static Factura generarFactura(Mesa mesaFactura){
        if (mesaFactura == null || mesaFactura.getPedidoMesa() == null){
            return null;
        }
        double totalPedido = calcularTotalPedido(mesaFactura.getPedidoMesa());
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

    public static <T> void escribirBinario (String ruta, T elemento){
        try {
            //Se crea un Stream para guardar archivo
            FileOutputStream f = new FileOutputStream(ruta);
            ObjectOutputStream file = new ObjectOutputStream(f);
            //Se escribe el objeto en archivo
            file.writeObject(elemento);
            //se cierra archivo
            file.close();
            f.close();
        } catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
        }
    }

    //Se implementa el método genérico en T para evitar errores a la hora del casteo.
    public static <T> T leerBinario(String ruta, Class <T> elemento)
    {
        try( ObjectInputStream file = new ObjectInputStream( new FileInputStream(ruta) ) ) {
            //Stream para leer archivo
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            //Se hace un Casting de Object a T
             T lista  = elemento.cast(file.readObject());
            //se cierra archivo
            file.close();
            return lista;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
