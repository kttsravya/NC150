package LeetCode.CloudKitchens.Task1;

public class Option extends Item{
    double price;

    public Option(int id, String name, ItemType type, double price) {
        super(id, name, type);
        this.price = price;
    }
}
