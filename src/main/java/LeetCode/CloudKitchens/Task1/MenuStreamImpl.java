package LeetCode.CloudKitchens.Task1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MenuStreamImpl implements MenuStream {
    List<String> sampleMenuData = Arrays.asList("4","CATEGORY", "PASTA", "1", "2", "","5",
            "ENTREE","Lasagna", "4.0", "1","2", "");

    private Iterator<String> iterator = sampleMenuData.iterator();

    @Override
    public String nextLine() {
        if(iterator.hasNext()){
            return iterator.next();
        }else{
            return null;
        }
    }
}
