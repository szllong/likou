/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-13 上午12:08
 * Author:cooper
 */

package oj.likou;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriority {

    @Test
    public void testPri() {
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>((o1, o2) -> o2.length() - o1.length());
        stringPriorityQueue.add("aa");
        stringPriorityQueue.add("aab");
        stringPriorityQueue.add("aacc");
        stringPriorityQueue.add("aaddd");
        String first = stringPriorityQueue.poll();
        String second = stringPriorityQueue.poll();

        System.out.println(stringPriorityQueue);
    }
}
