package oj.likou;

import org.junit.Test;

public class SudokuSolver {
    @Test
    public void test() {
        char[][] boards = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(boards);
        System.out.println(boards);
    }

    // box size
    int n = 3;
    // row size
    int N = n * n;
    private int[][] rows = new int[9][10];
    private int[][] cols = new int[9][10];
    private int[][] boxes = new int[9][10];
    private char[][] board;
    private boolean solved = false;

    private boolean canPlace(int row, int col, int d) {
        int idx = (row / n) * n + col / n;
        return 0 == rows[row][d] + cols[col][d] + boxes[idx][d];
    }

    private void placeNum(int row, int col, int d) {
        rows[row][d]++;
        cols[col][d]++;
        board[row][col] = (char) (d + '0');
        int idx = (row / n) * n + col / n;
        boxes[idx][d]++;
    }

    private void removeNum(int row, int col, int d) {
        rows[row][d]--;
        cols[col][d]--;
        board[row][col] = '.';
        int idx = (row / n) * n + col / n;
        boxes[idx][d]--;
    }


    private void placeNextNum(int row, int col) {
        if (row == N - 1 && col == N - 1) {
            solved = true;
        } else {
            if (col == N - 1) {
                backTrack(row + 1, 0);
            } else {
                backTrack(row, col + 1);
            }
        }
    }

    private void backTrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (canPlace(row, col, d)) {
                    placeNum(row, col, d);
                    placeNextNum(row, col);

                    if (!solved) {
                        removeNum(row, col, d);
                    }
                }
            }
        } else {
            placeNextNum(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    placeNum(i, j, board[i][j] - '0');
                }
            }
        }

        backTrack(0, 0);
    }
}