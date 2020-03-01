package oj.likou;

import org.junit.Test;

import java.util.Arrays;

public class TestRemoveElement {

    @Test
    public void test() {
    }

    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }
}
