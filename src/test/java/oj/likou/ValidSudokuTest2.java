/*
 * Copyright (c) cooper  2020.
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;

public class ValidSudokuTest2 {
    @Test
    public void test() {
        TestCase.assertFalse(isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] validRows = new int[10][10];
        int[][] validCols = new int[10][10];
        int[][] validBoxes = new int[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char tmpChar = board[i][j];
                if ('.' != tmpChar) {
                    int tmpInt = tmpChar - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    validRows[i][tmpInt] += 1;
                    validCols[tmpInt][j] += 1;
                    validBoxes[boxIndex][tmpInt] += 1;
                    if (validRows[i][tmpInt] >1 || validCols[tmpInt][j] > 1 || validBoxes[boxIndex][tmpInt] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
