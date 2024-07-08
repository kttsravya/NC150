package TwoPointers;

public class TrappingRainWater {
    public static void main(String[] args){
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int maxWaterTrapped = trappingRainWater.trap(new int[]{0,2,0,3,1,0,1,3,2,1});
        System.out.println(maxWaterTrapped);

    }

    public int trap(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxLeft = height[leftPointer];
        int maxRight = height[rightPointer];
        int trappedWater = 0;

        while(leftPointer < rightPointer){
           if(maxLeft <= maxRight){
               leftPointer ++;
               maxLeft = Math.max(maxLeft, height[leftPointer]);
               int waterTrappedAtCurrentStep = Math.min(maxLeft, maxRight) - height[leftPointer];
               if(waterTrappedAtCurrentStep > 0){
                   trappedWater = trappedWater + waterTrappedAtCurrentStep;
               }
           }else if(maxRight < maxLeft){
               rightPointer --;
               maxRight = Math.max(maxRight, height[rightPointer]);
               int waterTrappedAtCurrentStep = Math.min(maxLeft, maxRight) - height[rightPointer];
               if(waterTrappedAtCurrentStep > 0){
                   trappedWater = trappedWater + waterTrappedAtCurrentStep;
               }

           }
        }
        return trappedWater;
    }
}
