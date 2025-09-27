package LeetCode.CloudKitchens.Task1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Item> items;
    public Menu(){
        this.items = new ArrayList<>();
    }
    public void addMenuItem(Item item){
        this.items.add(item);
    }
}
