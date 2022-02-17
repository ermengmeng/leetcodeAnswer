import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/5/27 1:27 下午
 * @Version 1.0
 */
public class M416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        M416PartitionEqualSubsetSum o = new M416PartitionEqualSubsetSum();
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int partSum = sum / 2;
        boolean[] before = new boolean[partSum + 1];
        boolean[] cur = new boolean[partSum + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= partSum; j++) {
                if (nums[i - 1] > j) {
                    cur[j] = before[j];
                } else if (nums[i - 1] == j) {
                    cur[j] = true;
                } else {
                    cur[j] = before[j] || before[j - nums[i - 1]];
                }
            }
            if (cur[partSum]) {
                return true;
            }
            before = cur;
            cur = new boolean[partSum + 1];
        }
        return cur[partSum];
    }
}
