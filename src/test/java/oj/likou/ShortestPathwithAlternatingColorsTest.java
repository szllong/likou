/*
 * Copyright (c) 2010-2020.
 *  Date:20-5-7 下午11:07
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathwithAlternatingColorsTest {
    @Test
    public void test() {
//        TestCase.assertTrue(Arrays.equals(new int[]{0,1,-1}, shortestAlternatingPaths(3, new int[][]{{0,1}, {1,2}}, new int[][]{})));
//        TestCase.assertTrue(Arrays.equals(new int[]{0, 2, -1, -1, 1}, shortestAlternatingPaths(5, new int[][]{{3, 2}, {4, 1}, {1, 4}, {2, 4}}, new int[][]{{2, 3}, {0, 4}, {4, 3}, {4, 4}, {4, 0}, {1, 0}})));
        TestCase.assertTrue(Arrays.equals(new int[]{0, 1, 2, 2, 1}, shortestAlternatingPaths(5, new int[][]{
                        {2, 2}, {0, 4}, {4, 2}, {4, 3}, {2, 4}, {0, 0}, {0, 1}, {2, 3}, {1, 3}},
                new int[][]{{0, 4}, {1, 0}, {1, 4}, {0, 0}, {4, 0}})));
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        if (null == red_edges || null == blue_edges || n == 0) {
            return new int[n];
        }

        int[][] tempRedEdges1 = new int[red_edges.length][2];
        int[][] tempRedEdges2 = new int[red_edges.length][2];
        makeTempEdges(red_edges, tempRedEdges1, tempRedEdges2);

        int[][] tempBlueEdges1 = new int[blue_edges.length][2];
        int[][] tempBlueEdges2 = new int[blue_edges.length][2];
        makeTempEdges(blue_edges, tempBlueEdges1, tempBlueEdges2);

        int[] shortestPathsStartedFromRed = getShortestPaths(n, tempRedEdges1, tempBlueEdges1, true);
        int[] shortestPathsStartedFromBlue = getShortestPaths(n, tempRedEdges2, tempBlueEdges2, false);
        int[] shortedPaths = new int[n];
        for (int i = 0; i < n; i++) {
            if (shortestPathsStartedFromBlue[i] == -1) {
                shortedPaths[i] = shortestPathsStartedFromRed[i];
            } else if (shortestPathsStartedFromRed[i] == -1) {
                shortedPaths[i] = shortestPathsStartedFromBlue[i];
            } else if (shortestPathsStartedFromBlue[i] < shortestPathsStartedFromRed[i]) {
                shortedPaths[i] = shortestPathsStartedFromBlue[i];
            } else {
                shortedPaths[i] = shortestPathsStartedFromRed[i];
            }
        }

        return shortedPaths;
    }

    private void makeTempEdges(int[][] red_edges, int[][] tempRedEdges1, int[][] tempRedEdges2) {
        for (int i = 0; i < red_edges.length; i++) {
            tempRedEdges1[i][0] = red_edges[i][0];
            tempRedEdges1[i][1] = red_edges[i][1];
            tempRedEdges2[i][0] = red_edges[i][0];
            tempRedEdges2[i][1] = red_edges[i][1];
        }
    }

    private int[] getShortestPaths(int n, int[][] red_edges, int[][] blue_edges, boolean firstStartFromRed) {
        int[] shortestPaths = new int[n];
        Arrays.fill(shortestPaths, -1);
        shortestPaths[0] = 0;

        List<Integer> currentSelectNodePool = new ArrayList<>();
        currentSelectNodePool.add(0);

        int currentShortestPath = 1;

        boolean selectFromRed = firstStartFromRed;

        while (!currentSelectNodePool.isEmpty()) {
            if (selectFromRed) {
                fillShortedPathUsingSelectedPoll(red_edges, shortestPaths, currentSelectNodePool, currentShortestPath);
                selectFromRed = false;
            } else {
                fillShortedPathUsingSelectedPoll(blue_edges, shortestPaths, currentSelectNodePool, currentShortestPath);
                selectFromRed = true;
            }
            currentShortestPath++;
        }
        return shortestPaths;
    }

    private void fillShortedPathUsingSelectedPoll(int[][] edges, int[] shortestPaths, List<Integer> currentSelectNodePool, int currentShortestPath) {

        List<Integer> tempSelectNodePoll = new ArrayList<>();
        for (Integer currentSelectNode : currentSelectNodePool) {
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][0] == currentSelectNode) {
                    tempSelectNodePoll.add(edges[i][1]);
                    if (shortestPaths[edges[i][1]] == -1) {
                        shortestPaths[edges[i][1]] = currentShortestPath;
                    }
                    edges[i][0] = -1;
                }
            }
        }
        currentSelectNodePool.clear();
        currentSelectNodePool.addAll(tempSelectNodePoll);
        tempSelectNodePoll.clear();
    }
}
