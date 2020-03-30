/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-26 下午11:14
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class TestSearchinRotatedSortedArray {

    @Test
    public void test() {
        TestCase.assertEquals(0, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        TestCase.assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        TestCase.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        TestCase.assertEquals(-1, search(new int[]{4}, 0));
        TestCase.assertEquals(-1, search(new int[]{1, 3}, 2));
        TestCase.assertEquals(-1, search(new int[]{3, 5, 1}, 4));
        TestCase.assertEquals(-1, search(new int[]{1, 3}, 0));

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if (left == right) {
                if (target != midNum) {
                    return -1;
                } else {
                    return mid;
                }
            }
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else if (midNum == target) {
                return mid;
            } else {
                if (nums[left] <= nums[mid] && ((nums[left] > target && nums[mid] > target) || (nums[left] < target && nums[mid] < target))) {
                    left = mid + 1;
                    continue;
                }

                if (nums[left] <= nums[mid] && (nums[left] < target && nums[mid] > target)) {
                    right = mid - 1;
                    continue;
                }

                if (nums[mid] <= nums[right] && ((nums[right] > target && nums[mid] > target) || (nums[right] < target && nums[mid] < target))) {
                    right = mid - 1;
                    continue;
                }

                if (nums[mid] <= nums[right] && (nums[right] > target && nums[mid] < target)) {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
