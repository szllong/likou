/*
 * Copyright (c) 2010-2020.
 *  Date:20-3-30 下午10:53
 * Author:cooper
 */

package oj.likou;

import junit.framework.TestCase;
import org.junit.Test;

public class TestWordSearch {

    @Test
    public void test() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        TestCase.assertTrue(exist(board, "ABCCED"));
    }

    private String word;
    private char[][] board;
    private int row = 0;
    private int col = 0;

    private boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }

        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.word = word;
        this.marked = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, int index) {
        if (index == this.word.length() - 1) {
            return word.charAt(index) == board[i][j];
        }
        if (board[i][j] == this.word.charAt(index)) {
            marked[i][j] = true;

            if (charInBoard(i - 1, j) && !marked[i - 1][j] && backtrack(i - 1, j, index + 1)) {
                return true;
            }
            if (charInBoard(i + 1, j) && !marked[i + 1][j] && backtrack(i + 1, j, index + 1)) {
                return true;
            }
            if (charInBoard(i, j - 1) && !marked[i][j - 1] && backtrack(i, j - 1, index + 1)) {
                return true;
            }
            if (charInBoard(i, j + 1) && !marked[i][j + 1] && backtrack(i, j + 1, index + 1)) {
                return true;
            }
            marked[i][j] = false;
        }

        return false;
    }

    private boolean charInBoard(int i, int j) {
        return i >= 0 && i < this.row && j >= 0 && j < col;
    }


}
