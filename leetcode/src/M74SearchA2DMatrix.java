import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/24 6:35 下午
 * @Version 1.0
 */
public class M74SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println(new M74SearchA2DMatrix().searchMatrix(new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}}, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return Arrays.binarySearch(matrix[row], target) >= 0;
    }

    private int findRow(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (mid == matrix.length - 1) {
                return mid;
            }
            if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
                return mid;
            }
            if (matrix[mid][0] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (s + e) / 2;
    }
}
