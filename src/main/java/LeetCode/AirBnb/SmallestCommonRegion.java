package LeetCode.AirBnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SmallestCommonRegion {
    HashMap<String,String> childParentMap = new HashMap<>();
    public static void main(String[] args){
        SmallestCommonRegion region = new SmallestCommonRegion();
        List<List<String>> regions = Arrays.asList(Arrays.asList("Earth","North America","South America"),Arrays.asList("North America","United States","Canada"), Arrays.asList("United States","New York","Boston"),
                Arrays.asList("Canada","Ontario","Quebec"), Arrays.asList("South America","Brazil"));
        System.out.println(region.findSmallestRegion(regions, "Quebec", "New York"));
    }



    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
       createParentChildMap(regions);
       List<String> pathForRegion1 = fetchPathForRegion(region1);
       List<String> pathForRegion2 = fetchPathForRegion(region2);
       int iterator = 0;
       String prev = null;
       while(pathForRegion1.size() > iterator && pathForRegion2.size() > iterator && pathForRegion1.get(iterator).equals(pathForRegion2.get(iterator))){
           prev = pathForRegion1.get(iterator);
           iterator ++;
       }
       return prev;
    }

    // region path from root to region
    // start from region and get to the root and reverse the list
    private List<String> fetchPathForRegion(String region) {
        List<String> pathForRegion = new ArrayList<>();
        while (childParentMap.get(region) != null){
            pathForRegion.add(0, region);
            region = childParentMap.get(region);
        }
        pathForRegion.add(0, region);
        return pathForRegion;
    }

    private void createParentChildMap(List<List<String>> regions) {
        for(int i = 0; i < regions.size(); i ++){
            List<String> currentRegion = regions.get(i);
            String parent = currentRegion.get(0);
            for(int j = 1; j < currentRegion.size(); j ++){
                childParentMap.put(currentRegion.get(j), parent);
            }
        }
    }
}
