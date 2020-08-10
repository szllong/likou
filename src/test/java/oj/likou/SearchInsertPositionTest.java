/*
 * Copyright (c) 2010-2020.
 *  Date:20-4-7 下午11:06
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class SearchInsertPositionTest {

    @Test
    public void test() {
//        TestCase.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        TestCase.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        TestCase.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
        TestCase.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[mid] < target){
            return mid + 1;
        }else {
            return mid;
        }
    }
}
