/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 7:18 下午
 * @Version 1.0
 */
public class M64MinimumPathSum {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 2; i >= 0; i--) {
            grid[i][grid[0].length - 1] += grid[i + 1][grid[0].length - 1];
        }
        for (int i = grid[0].length - 2; i >= 0; i--) {
            grid[grid.length - 1][i] += grid[grid.length - 1][i + 1];
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
            }
        }
        return grid[0][0];
    }
}
