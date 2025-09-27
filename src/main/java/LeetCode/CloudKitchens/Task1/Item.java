package LeetCode.CloudKitchens.Task1;



abstract class Item {
    int id;
    String name;
    ItemType type;

    public Item(int id, String name, ItemType type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
