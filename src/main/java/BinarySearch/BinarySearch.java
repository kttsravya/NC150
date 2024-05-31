package BinarySearch;

import org.junit.Assert;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int targetIndex = binarySearchRecursive(nums, 0, nums.length - 1, target);
        System.out.println(targetIndex);
        return  targetIndex;
    }

    private int binarySearchRecursive(int[] nums, int low, int high, int target) {
        if(low > high){
            return -1;
        }
        int mid = (low + high)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] < target){
            return binarySearchRecursive(nums, mid + 1, high, target);
        }
        if(nums[mid] > target){
            return binarySearchRecursive(nums, low, mid - 1, target);
        }
        return -1;
    }
    // https://leetcode.com/problems/binary-search/
    // Idea is to think a way to find the position to insert the target element instead of finding the target
    // element
    public int binarySearchIterative_FindLastOccurrenceOfTargetElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length; // note maximum insert position could be nums.length
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] <= target){
                low = mid + 1;
            }else if (nums[mid] > target){
                high = mid;
            }
        }
        if(low > 0 && nums[low - 1] == target){
            return low -1;
        }
        return -1;
    }



    public int binarySearchIterative_FindLastOccurrenceOfTargetElement_find(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                if(mid + 1 < nums.length && nums[mid+1] != target){
                    return mid;
                }else{
                    if(mid + 1 >= nums.length){
                        return mid;
                    }else{
                        low = mid +1;
                    }
                }
            }
            if(nums[mid] < target){
                low = mid + 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }
        }
        return -1;
    }
    //nums = new int[]{-1,0,2,4,4,6,8};
    public int binarySearchIterative_FindFirstOccurrenceOfTargetElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length; // note maximum insert position could be nums.length
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] >= target){
                high = mid;
            }else if (nums[mid] < target){
                low = mid + 1;
            }
        }
        if(high >= 0 && nums[high] == target){
            return high;
        }
        return -1;
    }

    public static void main(String[] args){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1,0,2,4,6,8};
        int target = 4;
        int targetIndex = binarySearch.binarySearchRecursive(nums, 0, nums.length - 1, target);
        Assert.assertEquals(3, targetIndex);

        nums = new int[]{-1,0,2,4,4,6,8};
        target = 4;
        targetIndex = binarySearch.binarySearchIterative_FindLastOccurrenceOfTargetElement(nums, target);
        Assert.assertEquals(4, targetIndex);

        targetIndex = binarySearch.binarySearchIterative_FindLastOccurrenceOfTargetElement_find(nums, target);
        Assert.assertEquals(4, targetIndex);

        targetIndex = binarySearch.binarySearchIterative_FindFirstOccurrenceOfTargetElement(nums, target);
        Assert.assertEquals(3, targetIndex);
    }
}
