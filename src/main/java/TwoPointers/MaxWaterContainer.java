package TwoPointers;

public class MaxWaterContainer {
    public static void main(String[] args){
        MaxWaterContainer mwc = new MaxWaterContainer();
        int maxArea = mwc.maxArea(new int[]{2,2,2});
        System.out.println(maxArea);
    }

    public int maxArea(int[] heights) {
        int startPointer = 0;
        int endPointer = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(startPointer < endPointer){
            int width = (endPointer - startPointer);
            int height = Math.min(heights[startPointer], heights[endPointer]);
            int area = width*height;
            maxArea = Math.max(maxArea, area);
            if(heights[startPointer] < heights[endPointer]){
                startPointer ++;
            }else if(heights[startPointer] > heights[endPointer]){
                endPointer --;
            }else{
                // both have exact height
                if(heights[startPointer + 1] < heights[endPointer - 1]){
                    startPointer ++;
                }else{
                    endPointer --;
                }
            }
        }
        return maxArea;
    }
}
