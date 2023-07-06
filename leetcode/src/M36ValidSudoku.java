import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ouyangyameng
 * @Date: 2021/9/18 3:20 下午
 * @Version 1.0
 */
public class M36ValidSudoku {
    public static void main(String[] args) {
        M36ValidSudoku o = new M36ValidSudoku();
        System.out.println(o.isValidSudoku(new char[][] {
                new char[]{'5','3','.','.','7','.','.','.','.'},new char[]{'6','.','.','1','9','5','.','.','.'},new char[]{'.','9','8','.','.','.','.','6','.'},new char[]{'8','.','.','.','6','.','.','.','3'},new char[]{'4','.','.','8','.','3','.','.','1'},new char[]{'7','.','.','.','2','.','.','.','6'},new char[]{'.','6','.','.','.','.','2','8','.'},new char[]{'.','.','.','4','1','9','.','.','5'},new char[]{'.','.','.','.','8','.','.','7','9'}
        }));
    }


    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!set.add( i * 100 + 10 + board[i][j])) {
                    return false;
                }
                if (!set.add(j * 100 + 20 + board[i][j])) {
                    return false;
                }
                if (!set.add((i / 3 * 10 + j / 3) * 100 + 30 + board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
