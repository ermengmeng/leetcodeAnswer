/**
 * @Author: ouyangyameng
 * @Date: 2021/6/29 1:41 下午
 * @Version 1.0
 */
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        ContainerWithMostWater11 o = new ContainerWithMostWater11();
        System.out.println(o.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int left = 0,right = 0,max = 0;
        for (int i = 0; i< height.length; i++) {
            if (height[i]<=left) {
                continue;
            }
            left = height[i];
            right = 0;
            for (int j = height.length -1 ; j > 0; j--) {
                if (height[j]<=right) {
                    continue;
                }
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
                right = height[j];
            }
        }
        return max;
    }
}
