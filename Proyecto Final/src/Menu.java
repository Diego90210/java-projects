import java.util.ArrayList;

public class Menu {
    private ArrayList <ItemMenu> itemsMenu;

    public Menu(ArrayList <ItemMenu> itemsMenu){
        this.itemsMenu = itemsMenu;
    }

    public void setItemsMenu(ArrayList<ItemMenu> itemsMenu) {
        this.itemsMenu = itemsMenu;
    }

    public ArrayList<ItemMenu> getItemsMenu() {
        return itemsMenu;
    }
}
