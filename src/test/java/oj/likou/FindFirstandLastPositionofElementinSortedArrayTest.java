/*
 * Copyright (c) 2010-2020.
 *  Date:20-4-2 下午11:18
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArrayTest {

    @Test
    public void test() {
//        TestCase.assertTrue(Arrays.equals(new int[]{3, 4}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        TestCase.assertFalse(Arrays.equals(new int[]{-1, -1}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        TestCase.assertTrue(Arrays.equals(new int[]{0, 0}, searchRange(new int[]{1}, 1)));
        TestCase.assertTrue(Arrays.equals(new int[]{1, 1}, searchRange(new int[]{1,4}, 4)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || 0 == nums.length || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }


        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[mid] != target) {
            return new int[]{-1, -1};
        }

        int findedLeft = mid;
        int findedRight = mid;

        while (findedLeft >= 0 && nums[findedLeft] == target) {
            findedLeft--;
        }


        while (findedRight < nums.length && nums[findedRight] == target) {
            findedRight++;
        }
        return new int[]{findedLeft + 1, findedRight - 1};
    }
}
