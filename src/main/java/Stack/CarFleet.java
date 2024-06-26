package Stack;

import java.util.*;

public class CarFleet {
    public static void main(String[] args){
        int[] position = {6,8};
        int[] speed = {3,2};
        int target = 10;
        CarFleet carFleet = new CarFleet();
        int numOfCarFleets = carFleet.carFleet(target, position, speed);
        System.out.println(numOfCarFleets);

    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<double[]> list = new ArrayList<>();
        Stack<double[]> stack = new Stack<>();
        for (int pos = 0; pos < position.length; pos++) {
            double[] posSpeedAndTimeToReachTarget = new double[3];
            posSpeedAndTimeToReachTarget[0] = position[pos];
            posSpeedAndTimeToReachTarget[1] = speed[pos];
            list.add(posSpeedAndTimeToReachTarget);
        }
       list.sort(new Comparator<double[]>() {
           @Override
           public int compare(double[] o1, double[] o2) {
               return (int) (o2[0] - o1[0]);
           }
       });
        for(double[] element : list){
            System.out.println(Arrays.toString(element));
        }
        stack.add(list.get(0));
        list.get(0)[2] = (target - list.get(0)[0])/(double)list.get(0)[1];
        System.out.println("target to reach from "+ 0 + "is "+ list.get(0)[2]);

        for(int j= 1; j < list.size(); j ++){
            double timeToReachTargetFromCurrent = ((target - list.get(j)[0])/(double)list.get(j)[1]);
            System.out.println("target to reach from "+ j + "is "+ timeToReachTargetFromCurrent);
            if(timeToReachTargetFromCurrent > stack.peek()[2]){
                list.get(j)[2] = timeToReachTargetFromCurrent;
                stack.push(list.get(j));
            }
        }
        return stack.size();
    }
}
