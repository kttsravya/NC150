package LeetCode.CloudKitchens.Task1;

import java.util.List;

public class Entree extends Item{
    List<Integer> linkedItemIDs;
    double price;

    public Entree(int id, String name, ItemType type,
                  List<Integer> linkedItemIDs, double price){
        super(id, name, type);
        this.linkedItemIDs = linkedItemIDs;
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString()+"Entree{" +
                "linkedItemIDs=" + linkedItemIDs +
                ", price=" + price +
                '}';
    }
}
