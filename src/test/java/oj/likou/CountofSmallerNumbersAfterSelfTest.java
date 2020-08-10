/*
 * Copyright (c) 2010-2020.
 *  Date:20-4-22 下午11:45
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountofSmallerNumbersAfterSelfTest {

    @Test
    public void test() {
        List<Integer> result = countSmaller(new int[]{5, 2, 6, 1});
        int[] reArr = result.stream().mapToInt(Integer::valueOf).toArray();
        TestCase.assertTrue(Arrays.equals(new int[]{2, 1, 1, 0}, reArr));
    }

    @Test
    public void test1() {
        List<Integer> result = countSmaller(new int[]{0, 2, 1});
        int[] reArr = result.stream().mapToInt(Integer::valueOf).toArray();
        TestCase.assertTrue(Arrays.equals(new int[]{0, 1, 0}, reArr));
    }


    @Test
    public void test2() {
        List<Integer> result = countSmaller(new int[]{2, 1, 0});
        int[] reArr = result.stream().mapToInt(Integer::valueOf).toArray();
        TestCase.assertTrue(Arrays.equals(new int[]{2, 1, 0}, reArr));
    }

    @Test
    public void test3() {
        List<Integer> result = countSmaller(new int[]{10, 27, 10, 35, 12, 22, 28, 8, 19, 2, 12, 2, 9, 6, 12, 5, 17, 9, 19, 12, 14, 6, 12, 5, 12, 3, 0, 10, 0, 7, 8, 4, 0, 0, 4, 3, 2, 0, 1, 0});
        int[] reArr = result.stream().mapToInt(Integer::valueOf).toArray();
        TestCase.assertTrue(Arrays.equals(new int[]{23,36,23,36,24,33,33,19,30,7,22,7,18,14,19,12,22,16,21,17,19,13,16,12,15,8,0,12,0,9,9,7,0,0,5,4,3,0,1,0}, reArr));
    }

    @Test
    public void test5() {
        List<Integer> result = countSmaller(new int[]{65, 36, 100, 41});
        int[] reArr = result.stream().mapToInt(Integer::valueOf).toArray();
        TestCase.assertTrue(Arrays.equals(new int[]{2, 0, 1, 0}, reArr));
    }

    int[] lessThanINums = null;
    int[] indexes = null;
    int[] tmpIndexes = null;

    public List<Integer> countSmaller(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }
        lessThanINums = new int[nums.length];
        indexes = new int[nums.length];
        tmpIndexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
            tmpIndexes[i] = i;
        }

        sortNums(nums, 0, nums.length - 1);

        return Arrays.stream(lessThanINums).boxed().collect(Collectors.toList());
    }

    private void sortNums(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sortNums(nums, left, mid);
            sortNums(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmpIndexes[i] = indexes[i];
        }

        int leftStart = left;
        int rightStart = mid + 1;
        int indexStart = leftStart;
        while (leftStart <= mid && rightStart <= right) {
            if (nums[tmpIndexes[leftStart]] <= nums[tmpIndexes[rightStart]]) {
                indexes[indexStart] = tmpIndexes[leftStart];
                lessThanINums[indexes[indexStart]] += (rightStart - mid - 1);
                leftStart++;
                indexStart++;
            } else {
                indexes[indexStart] = tmpIndexes[rightStart];
                indexStart++;
                rightStart++;
            }
        }

        while (leftStart <= mid) {
            indexes[indexStart] = tmpIndexes[leftStart];
            lessThanINums[indexes[indexStart]] += (right - mid);
            indexStart++;
            leftStart++;
        }

        while (rightStart <= right) {
            indexes[indexStart] = tmpIndexes[rightStart];
            indexStart++;
            rightStart++;
        }
    }

}
