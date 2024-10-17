import java.util.ArrayList;

public class Pedido {
    private ArrayList <ItemPedido> items;
    private double total;


    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPedido> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
