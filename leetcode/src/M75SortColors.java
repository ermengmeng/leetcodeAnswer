/**
 * @Author: ouyangyameng
 * @Date: 2022/2/25 10:03 上午
 * @Version 1.0
 */
public class M75SortColors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i< nums.length; i++) {
            count[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (count[j] == 0) {
                j++;
            }
            count[j]--;
            nums[i] = j;
        }
    }
}
