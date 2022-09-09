import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/9 16:32
 * @Version 1.0
 */
public class M229MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            }
            if (num == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(num1);
        }
        if (count2 > nums.length / 3) {
            res.add(num2);
        }
        return res;
    }
}
