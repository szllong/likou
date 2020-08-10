/*
 * Copyright (c) 2010-2020.
 *  Date:20-5-25 上午12:02
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class FriendCirclesTest {
    @Test
    public void test() {
        int[][] M = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        TestCase.assertEquals(2, findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
        if (null == M || 0 == M[0].length) {
            return 0;
        }
        List<List<Integer>> metrix = new ArrayList<>();
        for (int[] students : M) {
            List<Integer> oneRow = new ArrayList<>();
            metrix.add(oneRow);
            for (Integer relation : students) {
                oneRow.add(relation);
            }
        }

        int circles = 0;
        Set<Integer> alreadyInCicle = new HashSet<>();
        for (Integer i = 0; i < metrix.size(); i++) {
            if (!alreadyInCicle.contains(i)) {
                Set<Integer> currentFriends = new HashSet<>();
                currentFriends.add(i);
                findAllFriendsOfI(metrix, currentFriends);
                alreadyInCicle.addAll(currentFriends);
                circles++;
            }
        }
        return circles;
    }

    private void findAllFriendsOfI(List<List<Integer>> metrix, Set<Integer> currentSet) {
        Set<Integer> tmpFriends = new HashSet<>();
        for (Integer current : currentSet) {
            List<Integer> oneRow = metrix.get(current);
            for (Integer i = 0; i < oneRow.size(); i++) {
                if (oneRow.get(i).equals(1)){
                    tmpFriends.add(i);
                }
            }
        }
        if (!tmpFriends.equals(currentSet)) {
            currentSet.addAll(tmpFriends);
            findAllFriendsOfI(metrix, currentSet);
        }
    }
}
