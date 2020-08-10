package oj.likou;

import org.junit.Test;

public class SudoSolverTest2 {
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

    public boolean canPlace(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        return rows[row][d] + cols[col][d] + boxes[idx][d] == 0;
    }

    public void placeNum(int d, int row, int col) {
        rows[row][d]++;
        cols[col][d]++;
        board[row][col] = (char) (d + '0');
        int idx = (row / n) * n + col / n;
        boxes[idx][d]++;
    }

    public void removeNum(int d, int row, int col) {
        rows[row][d]--;
        cols[col][d]--;
        board[row][col] = '.';
        int idx = (row / n) * n + col / n;
        boxes[idx][d]--;
    }

    public void placeNextNumbers(int row, int col) {

        if ((col == N - 1) && (row == N - 1)) {
            solved = true;
        } else {
            if (col == N - 1) {
                backtrack(row + 1, 0);
            } else {
                backtrack(row, col + 1);
            }
        }
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (canPlace(d, row, col)) {
                    placeNum(d, row, col);
                    placeNextNumbers(row, col);
                    if (!solved) {
                        removeNum(d, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNum(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}
