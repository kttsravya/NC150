package InterviewTips;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InterviewTips {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("joy is life");
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));

        String[] objectArray = new String[3];
        objectArray[0] = "Hello World SO Joy";
        objectArray[1] = "Hello World very Joy";
        System.out.println(Arrays.asList(objectArray).toString());

        int[] input = {1,2,3};
        Integer[] objectArray2 = Arrays.stream(input).boxed().toArray(Integer[]::new);
        List<Integer> list2 = Arrays.asList(objectArray2);
        System.out.println(list2.toString());
    }
}
