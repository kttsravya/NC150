package BinarySearch;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args){
        FindMinInRotatedSortedArray findMin = new FindMinInRotatedSortedArray();
        int min = findMin.findMin(new int[]{4,5,6,7});
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        // if size is one or nums are in ascending order
        if(nums.length == 1 || nums[0] < nums[nums.length - 1]){
            return nums[0];
        }
        // rotated
        int min=0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= nums[0]){
                low = mid + 1;
            }else{
                min = nums[mid];
                high = mid - 1;
            }
        }
        return min;
    }

}
