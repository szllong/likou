package oj.likou;

import org.junit.Test;

public class TestRemoveDuplicatesFromSortedArray {

    @Test
    public void test(){}

    public int removeDuplicates(int[] nums) {
        if (null == nums){
            return 0;
        }

        if (0 == nums.length || 1 == nums.length){
            return nums.length;
        }

        int cutLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cutLength] != nums[i]){
                cutLength++;
                nums[cutLength] = nums[i];
            }
        }

        return cutLength;
    }
}
