package InterviewPrep_2025.Neetcode150;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for detecting duplicates in integer arrays.
 * <p>
 * Provides an O(n) time, O(n) space approach using a {@link java.util.HashSet}
 * with early exit when a duplicate is encountered.
 * </p>
 * <p>
 * Note: Intended for algorithm practice; prefer unit tests over the demo {@code main}
 * for automated verification.
 * </p>
 */
public class ContainsDuplicate {
    /**
     * Demonstration entry point for manual execution.
     * Prints whether a sample array contains duplicates.
     */
    public static void main(String[] args) {
       int[] nums = {1,2,3,4};
       boolean hasDuplicates = hasDuplicate(nums);
       System.out.println(hasDuplicates);
    }

    /**
     * Returns whether the given array contains any duplicate value.
     *
     * @param nums the array of integers to examine; must not be {@code null}
     * @return {@code true} if any value appears more than once; {@code false} otherwise
     * @throws NullPointerException if {@code nums} is {@code null}
     */
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int iterator = 0;
        // Continue while each element is unique; Set.add returns false on duplicates (enables early exit)
        while (iterator < nums.length && hashSet.add(nums[iterator])) {
            iterator++;
        }
        return iterator < nums.length ? true : false;
    }
}
