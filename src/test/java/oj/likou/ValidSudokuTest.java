/*
 * Copyright (c) 2010-2020.
 *  Date:20-4-8 下午11:17
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class ValidSudokuTest {

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

    /**
     * [
     * ['.','.','.','.','5','.','.','1','.'],
     * ['.','4','.','3','.','.','.','.','.'],
     * ['.','.','.','.','.','3','.','.','1'],
     * ['8','.','.','.','.','.','.','2','.'],
     * ['.','.','2','.','7','.','.','.','.'],
     * ['.','1','5','.','.','.','.','.','.'],
     * ['.','.','.','.','.','2','.','.','.'],
     * ['.','2','.','9','.','.','.','.','.'],
     * ['.','.','4','.','.','.','.','.','.']
     * ]
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[] occurCount = new int[10];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(occurCount, 0);
            for (int j = 0; j < board[0].length; j++) {
                if (invalidSudoKu(occurCount, board[i][j])) {
                    return false;
                }
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            Arrays.fill(occurCount, 0);
            for (int i = 0; i < board.length; i++) {
                if (invalidSudoKu(occurCount, board[i][j])) {
                    return false;
                }
            }
        }

        for (int matrixRow = 0; matrixRow < 3; matrixRow++) {
            for (int matrixCol = 0; matrixCol < 3; matrixCol++) {
                Arrays.fill(occurCount, 0);
                for (int i = 3 * matrixRow; i < 3 * (matrixRow + 1); i++) {
                    for (int j = 3 * matrixCol; j < 3 * (matrixCol + 1); j++) {
                        if (invalidSudoKu(occurCount, board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean invalidSudoKu(int[] occurCount, char c) {
        if (c == '.') {
            return false;
        }
        if (occurCount[(c - '0')] == 1) {
            return true;
        } else {
            occurCount[c - '0'] = 1;
            return false;
        }
    }



}
