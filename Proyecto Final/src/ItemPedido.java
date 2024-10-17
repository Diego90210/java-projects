public class ItemPedido {
    private ItemMenu itemPed;
    private int cantidad;

    public ItemMenu getItemPed() {
        return itemPed;
    }

    public void setItemPed(ItemMenu itemPed) {
        this.itemPed = itemPed;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
}
