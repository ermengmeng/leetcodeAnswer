/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 5:43 下午
 * @Version 1.0
 */
public class M63UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{new int[]{0}, new int[]{1}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{1}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{1}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{1}, new int[]{1}, new int[]{0}, new int[]{1}, new int[]{0}, new int[]{0}, new int[]{1}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{1}};
        System.out.println(new M63UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] -= 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] += obstacleGrid[i - 1][0];
            }

        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] += obstacleGrid[0][i - 1];
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
