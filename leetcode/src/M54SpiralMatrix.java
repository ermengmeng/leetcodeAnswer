import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/16 5:15 下午
 * @Version 1.0
 */
public class M54SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(new M54SpiralMatrix().spiralOrder(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int visited = -101;
        int mode = 0;
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        ans.add(matrix[i][j]);
        matrix[i][j] = visited;
        while (ans.size() < matrix.length * matrix[0].length) {
            switch (mode) {
                case 0 :
                    while (j < matrix[0].length - 1 && matrix[i][j+1] != visited) {
                        j++;
                        ans.add(matrix[i][j]);
                        matrix[i][j] = visited;
                    }
                    break;
                case 1 :
                    while (i < matrix.length - 1 && matrix[i+1][j] != visited) {
                        i++;
                        ans.add(matrix[i][j]);
                        matrix[i][j] = visited;
                    }
                    break;
                case 2 :
                    while (j > 0 && matrix[i][j-1] != visited) {
                        j--;
                        ans.add(matrix[i][j]);
                        matrix[i][j] = visited;
                    }
                    break;
                case 3 :
                    while (i > 0 && matrix[i-1][j] != visited) {
                        i--;
                        ans.add(matrix[i][j]);
                        matrix[i][j] = visited;
                    }
                    break;

            }
            mode = (mode+1)%4;
        }
        return ans;
    }
}
