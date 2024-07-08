package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args){
        DailyTemperatures dt = new DailyTemperatures();
        int[] temp = {30,38,30,36,35,40,28};
        int[] output = dt.dailyTemperatures(temp);
        System.out.println(Arrays.toString(output));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]>  stack = new Stack<>();
        int[] output = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i ++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] element = stack.pop();
                output[element[1]] = i - element[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return output;
    }
}
