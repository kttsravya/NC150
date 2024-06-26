package BinarySearch;

public class FindTargetInRotatedSortedArray {
    public static void main(String[] args){
        FindTargetInRotatedSortedArray targetInRotatedSortedArray = new FindTargetInRotatedSortedArray();
        int min = targetInRotatedSortedArray.searchOptimized(new int[]{3,4,5,6,1,2}, 1);
        System.out.println(min);
    }

    public int search(int[] nums, int target) {
        int minValueIndex = searchMinValueIndex(nums);
        int targetIndex = -1;
        // non-rotated array
        if(minValueIndex == 0){
             targetIndex = binarySearch(nums, 0, nums.length-1, target);
        }
        // rotated array, target in second sorted portion of subarray
        if(minValueIndex > 0 && target >= nums[minValueIndex] && target <= nums[nums.length - 1]){
             targetIndex = binarySearch(nums, minValueIndex, nums.length-1, target);
        }
        // roatated array, target in first sorted portion of subarray
        if(minValueIndex > 0 && target >= nums[0] && target <= nums[minValueIndex - 1]){
             targetIndex = binarySearch(nums, 0, minValueIndex - 1, target);
        }
        return targetIndex;
    }

    public int searchOptimized(int[] nums, int target) {
       int low = 0;
       int high = nums.length - 1;
       while (low <= high){
           int mid = (low + high)/2;
           if(target == nums[mid]){
               return mid;
           }
           //left sorted portion
           if(nums[mid] >= nums[low]){
               if(target > nums[mid]){
                   low = mid + 1;
               }else if(target < nums[mid]){
                   if(target >= nums[low]){
                       high = mid - 1;
                   }else if(target < nums[low]){
                       low = mid + 1;
                   }
               }
           }else{ // right sorted portion
               if(target < nums[mid]){
                   high = mid - 1;
               }else if (target > nums[mid]){
                   if(target > nums[high]){
                       high = mid - 1;
                   }else{
                       low = mid + 1;
                   }
               }
           }
       }
       return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end;
        while(low <= high){
            int mid = (low + high)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    private int searchMinValueIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int minIndex = 0;
        while(low <= high){
            if(nums[low] <= nums[high]){
                return low;
            }
            int mid = (low + high)/2;
            // we are in first sorted subarray
            if(nums[mid] >= nums[low]){
                low = mid + 1;
            }else{ // we are in second sorted subarray
                high = mid;
            }
        }
        return low;
    }
}
