/**
 * @Author: ouyangyameng
 * @Date: 2021/6/29 1:41 下午
 * @Version 1.0
 */
public class M11ContainerWithMostWater {
    public static void main(String[] args) {
        M11ContainerWithMostWater o = new M11ContainerWithMostWater();
        System.out.println(o.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] <= left) {
                continue;
            }
            left = height[i];
            right = 0;
            for (int j = height.length - 1; j > 0; j--) {
                if (height[j] <= right) {
                    continue;
                }
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
                right = height[j];
            }
        }
        return max;
    }

    //从两边向中间移动，想得到更大值必须要使Math.min(height[i], height[j])变大，因此每次挪动其中较小的那个来达到最大值的遍历
    public int bestMaxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
