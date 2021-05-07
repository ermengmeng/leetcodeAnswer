/**
 * @Author: ouyangyameng
 * @Date: 2021/5/7 1:28 下午
 * @Version 1.0
 */
public class MaxAreaofIsland695 {
    public static void main(String[] args) {
        MaxAreaofIsland695 o = new MaxAreaofIsland695();
        o.maxAreaOfIsland(new int[][]{});
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, computeIsLand(i, j, grid));
                }
            }
        }
        return max;
    }

    private int computeIsLand(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == 0) {
            return 0;
        }
        int cur = 1;
        grid[i][j] = 0;
        cur += computeIsLand(i - 1, j, grid);
        cur += computeIsLand(i, j - 1, grid);
        cur += computeIsLand(i + 1, j, grid);
        cur += computeIsLand(i, j + 1, grid);
        return cur;
    }
}
