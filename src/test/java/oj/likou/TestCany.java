package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class TestCany {

    @Test
    public void testCandy() {
        TestCase.assertEquals(2, candy(new int[]{0, 0}));
        TestCase.assertEquals(5, candy(new int[]{1, 0, 2}));
        TestCase.assertEquals(4, candy(new int[]{1, 2, 2}));
        TestCase.assertEquals(13, candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        TestCase.assertEquals(15, candy(new int[]{3, 2, 1, 2, 3, 4}));
        TestCase.assertEquals(18, candy(new int[]{1, 6, 10, 8, 7, 3, 2}));

        TestCase.assertEquals(15, candy(new int[]{0, 1, 2, 5, 3, 2, 7}));
        TestCase.assertEquals(21, candy(new int[]{1, 2, 3, 5, 4, 3, 2, 1}));
        TestCase.assertEquals(47, candy(new int[]{1, 2, 3, 5, 4, 3, 2, 1, 4, 3, 2, 1, 3, 2, 1, 1, 2, 3, 4}));
    }

    public int candy(int[] ratings) {
        if (null == ratings || 0 == ratings.length) {
            return 0;
        }
        if (1 == ratings.length) {
            return 1;
        }

        int lastIncreaseNums = 0;
        int startPosition = 0;
        int count = 0;
        while (startPosition < ratings.length) {
            if (startPosition == (ratings.length - 1)) {
                if (ratings[startPosition] > ratings[startPosition - 1]) {
                    count += 2;
                    return count;
                } else {
                    count += 1;
                    return count;
                }
            }
            if (ratings[startPosition] == ratings[startPosition + 1]) {
                count++;
                startPosition++;
                lastIncreaseNums = 1;
            } else if (ratings[startPosition] < ratings[startPosition + 1]) {
                int nums = findIncreaseNums(startPosition, ratings);
                count += nums * (nums + 1) / 2;
                if (startPosition > 0 && ratings[startPosition] > ratings[startPosition - 1]) {
                    count += nums;
                }
                startPosition += nums;
                lastIncreaseNums = nums;
            } else {
                int nums = findDecreaseNums(startPosition, ratings);
                count += nums * (nums + 1) / 2;
                if (nums >= lastIncreaseNums && 0 != lastIncreaseNums && ratings[startPosition] < ratings[startPosition - 1]) {
                    count += nums - lastIncreaseNums + 1;
                }
                startPosition += nums;
                lastIncreaseNums = 0;
            }
        }
        return count;
    }

    private int findDecreaseNums(int startPosition, int[] ratings) {
        int minSegValue = Integer.MAX_VALUE;
        int nums = 0;
        for (int i = startPosition; i < ratings.length; i++) {
            if (ratings[i] < minSegValue) {
                minSegValue = ratings[i];
                nums++;
            } else {
                break;
            }
        }
        return nums;
    }

    private int findIncreaseNums(int startPosition, int[] ratings) {
        int maxSegValue = Integer.MIN_VALUE;
        int nums = 0;
        for (int i = startPosition; i < ratings.length; i++) {
            if (ratings[i] > maxSegValue) {
                maxSegValue = ratings[i];
                nums++;
            } else {
                break;
            }
        }
        return nums;
    }

}
