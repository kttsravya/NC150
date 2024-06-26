package Stack;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> stack;
    List<Integer> minStack;
    int top = -1;
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        Assert.assertEquals(minStack.getMin(),0);; // return 0
        minStack.pop();
        int top = minStack.top();    // return 2
        Assert.assertEquals(top, 2);
        Assert.assertEquals(minStack.getMin(), 1); // return 1
    }

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(top + 1,val);
        if(top >=0){
            int prevMinElement = minStack.get(top);
            minStack.add(top+1, Math.min(val, prevMinElement));
        }else{
            minStack.add(top+1, val);
        }
        top ++;
    }

    public void pop() {
        stack.remove(top);
        minStack.remove(top);
        top --;
    }

    public int top() {
       return stack.get(top);
    }

    public int getMin() {
        return minStack.get(top);
    }

}
