import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/9 16:32
 * @Version 1.0
 */
public class M229MajorityElement2 {
    //求数量大于n/3的数字，推广到数量大于n/k的数字
    //首先不可能存在k个大于n/k个数字,即数量大于n/k的数字的个数最多为k-1个。
    //我们设置k-1个计数位。
    //我们假设有1个超过n/k个的数字,为x
    //因为在所有k-1个计数位全都有数字时,出现新的数字才会对x的count进行--;
    //因此每出现一次针对countx的--,都会消耗k-1个数字。
    //又因为countx的数量>n/k,所以剩余的数字的数量小于(k-1)n/k
    //因此,最终countx一定>0
    //同理可推出存在2,3,……,k-2,k-1个大于n/k个数字的情况成立。
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
