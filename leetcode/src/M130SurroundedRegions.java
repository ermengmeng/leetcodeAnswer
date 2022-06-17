/**
 * @Author: ouyangyameng
 * @Date: 2022/6/16 19:16
 * @Version 1.0
 */
public class M130SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                computeSafe(i, 0, board);
            }
            if (board[i][board[0].length - 1] == 'O') {
                computeSafe(i, board[0].length - 1, board);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                computeSafe(0, i, board);
            }
            if (board[board.length - 1][i] == 'O') {
                computeSafe(board.length - 1, i, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void computeSafe(int x, int y, char[][] board) {
        board[x][y] = 'S';
        if (x > 0 && board[x - 1][y] == 'O') {
            computeSafe(x - 1, y, board);
        }
        if (x < board.length - 1 && board[x + 1][y] == 'O') {
            computeSafe(x + 1, y, board);
        }
        if (y > 0 && board[x][y - 1] == 'O') {
            computeSafe(x, y - 1, board);
        }
        if (y < board[0].length - 1 && board[x][y + 1] == 'O') {
            computeSafe(x, y + 1, board);
        }
    }
}
