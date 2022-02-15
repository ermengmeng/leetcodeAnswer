/**
 * @Author: ouyangyameng
 * @Date: 2022/2/15 6:40 下午
 * @Version 1.0
 */
public class M79WordSearch {
    public static void main(String[] args) {
        M79WordSearch o = new M79WordSearch();
        System.out.println(o.exist(new char[][]{new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'E', 'S'}, new char[]{'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    boolean[][] isVisited = new boolean[board.length][board[0].length];
                    boolean res = search(i, j, 1, word.toCharArray(), board, isVisited);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, int k, char[] word, char[][] board, boolean[][] isVisited) {
        if (k == word.length) {
            return true;
        }
        char c = word[k];
        isVisited[i][j] = true;
        if (i < board.length - 1 && board[i + 1][j] == c && !isVisited[i + 1][j]) {
            boolean res = search(i + 1, j, k + 1, word, board, isVisited);
            if (res) return true;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == c && !isVisited[i][j + 1]) {
            boolean res = search(i, j + 1, k + 1, word, board, isVisited);
            if (res) return true;
        }
        if (i > 0 && board[i - 1][j] == c && !isVisited[i - 1][j]) {
            boolean res = search(i - 1, j, k + 1, word, board, isVisited);
            if (res) return true;
        }
        if (j > 0 && board[i][j - 1] == c && !isVisited[i][j - 1]) {
            boolean res = search(i, j - 1, k + 1, word, board, isVisited);
            if (res) return true;
        }
        isVisited[i][j] = false;
        return false;
    }
}
