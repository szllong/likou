/*
 * Copyright (c) 2010-2020.
 *  Date:20-5-25 下午11:10
 * Author:cooper
 */

package oj.likou;

import org.junit.Test;

public class CarPoolingTest {

    @Test
    public void test(){}

    public boolean carPooling(int[][] trips, int capacity) {
        int[] capacityGreedy = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            capacityGreedy[trips[i][1]] += trips[i][0];
            capacityGreedy[trips[i][2]] -= trips[i][0];
        }

        int currentCapacity = 0;
        for (int i = 0; i < 1001; i++) {
            currentCapacity += capacityGreedy[i];
            if (currentCapacity > capacity){
                return false;
            }
        }

        return true;
    }
}
