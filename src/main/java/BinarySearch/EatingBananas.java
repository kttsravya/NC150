package BinarySearch;

public class EatingBananas {
    public static void main(String[] args){
        EatingBananas eatingBananas = new EatingBananas();
        int minK = eatingBananas.minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000 );
        System.out.println(minK);
    }

    public int minEatingSpeed(int[] piles, int h) {
        System.out.println(" h is "+ h);
        //findMaxK
        int maxK = 0;
        long sum = 0;
        for(int i = 0; i < piles.length; i ++){
            if(piles[i] > maxK){
                maxK = piles[i];
            }
            sum = sum + piles[i];
        }
        System.out.println("Sum is "+ sum);
        System.out.println("maxK is "+ maxK);

        // perform binary search in range from 1 to maxK
        int low = 1;
        int high = maxK;
        int k = 0;
        while(low <= high){
            int mid = (low + high)/2;
            System.out.println("mid is "+ mid);
            long totalHrs = getNumberOfHrsRequiredToConsumeAllItemsAtGivenRate(mid, piles);
            System.out.println("totalHrs is " + totalHrs);
            // eating pace is too sloww.. taking more than h hours
            if(totalHrs > h){
                System.out.println("totalHrs is greater than h"+ totalHrs + " "+ h);
                low = mid + 1;
            }else{
                // found k to complete all items within h hours, try to find value lesser than current minimum(k)
               k = mid;
               high = mid - 1;
            }
        }
        return k;
    }

    private long getNumberOfHrsRequiredToConsumeAllItemsAtGivenRate(int mid, int[] piles) {
        long totalHrs = 0;
        for(int i = 0; i < piles.length; i ++){
            totalHrs = totalHrs + (int)Math.ceil(piles[i]/(double)mid);
        }
        System.out.println("total hrs being taken for given mid is "+ mid + " "+ totalHrs);
        return totalHrs;
    }

}
