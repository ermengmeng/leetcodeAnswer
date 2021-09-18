import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ouyangyameng
 * @Date: 2021/9/18 3:20 下午
 * @Version 1.0
 */
public class ValidSudoku36 {
    public static void main(String[] args) {
        ValidSudoku36 o = new ValidSudoku36();
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
                if (!set.add( i * 1000 + 100 + board[i][j])) {
                    return false;
                }
                if (!set.add(j * 1000 + 200 + board[i][j])) {
                    return false;
                }
                if (!set.add((i / 3 * 10 + j / 3) * 1000 + 300 + board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
