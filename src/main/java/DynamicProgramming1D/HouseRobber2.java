package DynamicProgramming1D;

public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        int output = houseRobber2.rob(new int[]{1, 2, 3, 1});
        System.out.println(output);
    }

    private int robHelper(int[] nums, int start, int size) {
        int adjacentHome = nums[size - 1];
        System.out.println(adjacentHome);
        int alternateHome = 0;
        System.out.println(alternateHome);
        for (int index = size - 2; index >= start; index--) {
            int current = Math.max(nums[index] + alternateHome, adjacentHome);
            System.out.println("index is " + index + "and current value is " + current);
            alternateHome = adjacentHome;
            adjacentHome = current;
        }
        return adjacentHome;
    }


    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(nums, 0, nums.length - 1),
                robHelper(nums, 1, nums.length));
    }

}
