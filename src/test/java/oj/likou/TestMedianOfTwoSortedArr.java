package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class TestMedianOfTwoSortedArr {

    @Test
    public void test() {
        TestCase.assertEquals(2.0, findMedian(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedian(int[] arr1, int[] arr2) {
        if (null == arr1 || null == arr2) {
            return medianForNull(arr1, arr2);
        }
        if (arr1.length > arr2.length) {
            int[] tmpArr = arr1;
            arr1 = arr2;
            arr2 = tmpArr;
        }
        int m = arr1.length, n = arr2.length;
        int imin = 0, imax = arr1.length;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < imax && arr1[i] < arr2[j - 1]) {
                imin = i + 1;
            } else if (i > 0 && arr1[i - 1] > arr2[j]) {
                imax = i - 1;
            } else {
                int maxLeft = 0;
                if (0 == i) {
                    maxLeft = arr2[j - 1];
                } else if (j == 0) {
                    maxLeft = arr1[i - 1];
                } else {
                    maxLeft = Math.max(arr1[i - 1], arr2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (m == i) {
                    minRight = arr2[j];
                } else if (n == j) {
                    minRight = arr1[i];
                } else {
                    minRight = Math.min(arr1[i], arr2[j]);
                }

                return ((double) maxLeft + minRight) / 2;
            }
        }

        return 0;
    }

    private int medianForNull(int[] arr1, int[] arr2) {
        if (null == arr1 && null == arr2) {
            return 0;
        }

        if (null == arr1) {
            arr1 = arr2;
        }
        if (arr1.length % 2 == 0) {
            return (arr1[arr1.length / 2] + arr1[arr1.length / 2 + 1]) / 2;
        } else {
            return arr1[arr1.length / 2];
        }
    }
}
