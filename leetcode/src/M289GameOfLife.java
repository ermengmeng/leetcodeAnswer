/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 14:06
 * @Version 1.0
 */
public class M289GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] % 10 == 1) {
                    dealAlive(i, j, board);
                }
                judge(i, j, board);
            }
        }
    }

    private void dealAlive(int i, int j, int[][] board) {
        if (i > 0 && j > 0) {
            board[i - 1][j - 1] += 10;
        }
        if (i > 0) {
            board[i - 1][j] += 10;
        }
        if (i > 0 && j < board[0].length - 1) {
            board[i - 1][j + 1] += 10;
        }
        if (j > 0) {
            board[i][j - 1] += 10;
        }
        if (j < board[0].length - 1) {
            board[i][j + 1] += 10;
        }
        if (i < board.length - 1 && j > 0) {
            board[i + 1][j - 1] += 10;
        }
        if (i < board.length - 1) {
            board[i + 1][j] += 10;
        }
        if (i < board.length - 1 && j < board[0].length - 1) {
            board[i + 1][j + 1] += 10;
        }
    }

    private void judge(int i, int j, int[][] board) {
        if (i > 0 & j > 0) {
            board[i - 1][j - 1] = convert(board[i - 1][j - 1]);
        }
        if (i > 0 & j == board[0].length - 1) {
            board[i - 1][j] = convert(board[i - 1][j]);
        }
        if (i == board.length - 1 && j > 0) {
            board[i][j - 1] = convert(board[i][j - 1]);
        }
        if (i == board.length - 1 && j == board[0].length - 1) {
            board[i][j] = convert(board[i][j]);
        }
    }

    private int convert(int value) {
        if (value % 10 == 1) {
            return value < 20 || value > 40 ? 0 : 1;
        } else {
            return value == 30 ? 1 : 0;
        }
    }
}
