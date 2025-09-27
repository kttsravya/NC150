import InterviewPrep_2025.Neetcode150.ContainsDuplicate;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    @Test
    public void emptyArray_returnsFalse() {
        int[] nums = new int[]{};
        assertFalse(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void singleElement_returnsFalse() {
        int[] nums = new int[]{42};
        assertFalse(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void allUnique_returnsFalse() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        assertFalse(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void consecutiveDuplicates_returnsTrue() {
        int[] nums = new int[]{1, 1, 2};
        assertTrue(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void nonConsecutiveDuplicates_returnsTrue() {
        int[] nums = new int[]{1, 2, 3, 1};
        assertTrue(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void negativeAndZeroDuplicates_returnsTrue() {
        int[] nums = new int[]{0, -1, -2, 0};
        assertTrue(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void largeArray_duplicateNearEnd_returnsTrue() {
        int n = 10000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i; // unique initially
        }
        nums[n - 1] = nums[n / 2]; // introduce a duplicate at the end
        assertTrue(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test
    public void handlesMinAndMaxValueDuplicates_returnsTrue() {
        int[] nums = new int[]{Integer.MIN_VALUE, 1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        assertTrue(ContainsDuplicate.hasDuplicate(nums));
    }

    @Test(expected = NullPointerException.class)
    public void nullArray_throwsNullPointerException() {
        ContainsDuplicate.hasDuplicate(null);
    }
}
