package Company.HubSpot_Company;


import java.util.Arrays;
import java.util.List;

public class ConcurrentCalls {

    public static void main(String[] args){
        ConcurrentCalls concurrentCalls = new ConcurrentCalls();
        int[][] input = {{1,3}, {2,4}, {3,4}, {3,4},{3,4}, {3,5}, {4,6}, {4, 7},{7,8}, {8,9},{8,9},{8,9},{8,11}};
        int maxs = concurrentCalls.getMaxConcurrentConnectionsInfo(Arrays.asList(input));
        System.out.println(maxs);
    }

    public int getMaxConcurrentConnectionsInfo(List<int[]> input){
        int concurrentCalls = 1;
        int maxConcurrentCalls = 0;
        if(input.isEmpty() || input.size() == 1){
            return input.size();
        }
        int prevEnd = input.get(0)[1];
        int[] intersectionPoint = new int[]{-1, -1};
        for(int i = 1; i < input.size(); i ++){
            int[] current = input.get(i);
            int currentStart = current[0];
            if(currentStart < prevEnd){ // overlapping with previous interval
                if(isIntersecting(intersectionPoint, current, prevEnd)){ // is Intersecting with previous concurrent calls?
                    concurrentCalls ++;
                    if(concurrentCalls > maxConcurrentCalls){
                        maxConcurrentCalls = concurrentCalls;
                    }
                }
                prevEnd = Math.max(current[1], prevEnd);
            }else{ // not overlapping with previous interval
               prevEnd = current[1];
               concurrentCalls = 1;
            }
        }
        return maxConcurrentCalls;
    }

    private boolean isIntersecting(int[] intersectionPoint, int[] current, int prevEnd) {
        // not intersecting
        if(intersectionPoint[0] == -1){
            intersectionPoint[0] = current[0];
            intersectionPoint[1] = prevEnd;
            return true;
        }
        if(current[0] < intersectionPoint[1]){
            intersectionPoint[0] = current[0];
            intersectionPoint[1] = prevEnd;
            return true;
        } else{
            intersectionPoint[0] = current[0];
            intersectionPoint[1] = prevEnd;
            return false;
        }
    }


}
