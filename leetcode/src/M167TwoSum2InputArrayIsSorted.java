import java.lang.reflect.Array;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/8 10:20
 * @Version 1.0
 */
public class M167TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = numbers.length - 1;
        while (s < e) {
            if (numbers[s] + numbers[e] > target) {
                e--;
            } else if (numbers[s] + numbers[e] < target) {
                s++;
            } else {
                return new int[]{s + 1, e + 1};
            }
        }
        return new int[0];
    }
}
