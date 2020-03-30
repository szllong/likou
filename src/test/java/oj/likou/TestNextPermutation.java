/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-19 下午11:41
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class TestNextPermutation {

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        TestCase.assertEquals(Arrays.asList(1, 3, 2).toString(), Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{3, 2, 1};
        nextPermutation(nums);
        TestCase.assertEquals(Arrays.asList(1, 2, 3).toString(), Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1, 1, 5};
        nextPermutation(nums);
        TestCase.assertEquals(Arrays.asList(1, 5, 1).toString(), Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        TestCase.assertEquals(Arrays.asList(2, 1, 3).toString(), Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int index;
        for (index = nums.length - 1; index > 0; index--) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
        }
        if (index > 0) {
            int bigIndex;
            for (bigIndex = nums.length - 1; bigIndex >= index; bigIndex--) {
                if (nums[index - 1] < nums[bigIndex]) {
                    break;
                }
            }
            int tmp = nums[index - 1];
            nums[index - 1] = nums[bigIndex];
            nums[bigIndex] = tmp;
            reverse(nums, index, nums.length - 1);
        } else {
            int left = 0, right = nums.length - 1;
            reverse(nums, left, right);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
    }


}
