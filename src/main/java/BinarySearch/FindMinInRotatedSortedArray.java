package BinarySearch;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args){
        FindMinInRotatedSortedArray findMin = new FindMinInRotatedSortedArray();
        int min = findMin.findMinRev2(new int[]{5,0,1,2});
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

    public int findMinRev(int[] nums) {
       int low = 0;
       int high = nums.length - 1;
       if(nums[low] < nums[high]){
           return nums[low];
       }
       while(low <= high){
           int mid = (low + high)/2;
           if(nums[mid] > nums[high]){
               low = mid + 1;
           }else if (nums[mid] < nums[low]){
              high = mid;
           }else{
               return nums[low];
           }
       }
       return -1;

    }

    public int findMinRev2(int[] nums) {
       int low = 0;
       int high = nums.length - 1;
       int mid = (low + high)/2;
       if(nums[low] < nums[high]){
           return nums[low];
       }
       while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] < nums[high] && nums[mid - 1] < nums[mid]){
                high = mid - 1;
            }else if (nums[mid] > nums[high]){
                low = mid + 1;
            }else{
               return nums[mid];
            }
       }
       return -1;
    }
}
