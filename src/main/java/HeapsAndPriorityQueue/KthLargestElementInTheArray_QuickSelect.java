package HeapsAndPriorityQueue;

public class KthLargestElementInTheArray_QuickSelect {
    public static void main(String[] args){
        KthLargestElementInTheArray_QuickSelect quickSelect = new KthLargestElementInTheArray_QuickSelect();
        int[] nums = {2,1};
        int k = 1;
        int res = quickSelect.findKthLargest(nums, k);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, 0, nums.length - 1, k);
    }
    private int findKthLargestHelper(int[] nums, int low, int high, int k){
        int kthLargest = -1;
        if(low <= high){
            int pivotPosition = partition(nums, low, high);
            System.out.println("pivot position is "+pivotPosition);
            if(pivotPosition == nums.length - k){
                return nums[pivotPosition];
            }
            if(pivotPosition > nums.length - k){
                kthLargest = findKthLargestHelper(nums, low, pivotPosition -1, k);
            }else{
                System.out.println("Inside else");
                kthLargest =  findKthLargestHelper(nums, pivotPosition+1, high, k);
            }
        }
        return kthLargest;
    }

    private int partition(int[] input, int low, int high) {
        int pivot = input[high];
        System.out.println("pivot is "+pivot);
        int pivotPosition = low;
        System.out.println("pivot position is "+ pivotPosition);
        for(int i = low; i < high; i ++){
            System.out.println("Inside For Loop");
            if(input[i] <= pivot){
                int temp = input[pivotPosition];
                input[pivotPosition] = input[i];
                input[i] = temp;
                pivotPosition ++;
            }
        }
        int temp = input[pivotPosition];
        input[pivotPosition] = pivot;
        input[high] = temp;
        return pivotPosition;
    }
}
