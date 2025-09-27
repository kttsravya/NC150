package LeetCode.CloudKitchens.Task1;

import java.util.ArrayList;
import java.util.List;


public class MenuGenerator {

    public static void main(String[] args){
        MenuStreamImpl menuStream = new MenuStreamImpl();
        Menu menu = new Menu();
        List<String> buffer = new ArrayList<>();
        Item item = null;
        String current = menuStream.nextLine();
        while(current != null){
            if(current.isEmpty()){
                int id = Integer.parseInt(buffer.get(0));
                String type = buffer.get(1);
                System.out.println("type is "+ type);
                String name = buffer.get(2);
                List<Integer> linkedItems = new ArrayList<>();

                if(type.equals(ItemType.ENTREE.name())){
                    double price = Double.parseDouble(buffer.get(3));
                    item = new Entree(id, name, ItemType.ENTREE, linkedItems, price);
                }
                if(type.equals(ItemType.OPTION.name())){
                    double price = Double.parseDouble(buffer.get(3));
                    item = new Option(id, name, ItemType.OPTION, price);
                }
                int index = -1;
                if(type.equals(ItemType.CATEGORY.name())){
                    index = 3;
                    item = new Category(id, name, ItemType.CATEGORY, linkedItems);
                }
                if(type.equals(ItemType.ENTREE.name())){
                    index = 4;
                }
                if(buffer.size() > index && (type.equals(ItemType.CATEGORY.name()) || type.equals(ItemType.ENTREE.name()))){
                   for(int i = index; i < buffer.size() && !buffer.get(i).isEmpty(); i ++){
                       linkedItems.add(Integer.parseInt(buffer.get(i)));
                   }
                }
                 menu.items.add(item);
                 System.out.println(item.toString());
                 buffer.clear();
            }else{
                buffer.add(current);
                System.out.println("buffer is " +buffer.toString());
            }
            current = menuStream.nextLine();
            System.out.println("current is " + current);
        }
        System.out.println(menu.toString());
    }
}
