package LeetCode.CloudKitchens.Task1;

import java.util.List;

public class Category extends Item{
    List<Integer> linkedItemIDs;

    public Category(int id, String name, ItemType type, List<Integer> linkedItemIDs) {
        super(id, name, type);
        this.linkedItemIDs = linkedItemIDs;
    }

    @Override
    public String toString() {
        return super.toString() + "Category{" +
                "linkedItemIDs=" + linkedItemIDs +
                '}';
    }
}
