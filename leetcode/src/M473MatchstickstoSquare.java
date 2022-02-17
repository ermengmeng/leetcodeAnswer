import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/19 8:07 下午
 * @Version 1.0
 */
public class M473MatchstickstoSquare {
    public static void main(String[] args) {
        M473MatchstickstoSquare o = new M473MatchstickstoSquare();
        System.out.println(o.makesquare(new int[]{}));
    }

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int n = sum / 4;
        Arrays.sort(nums);
        return dfs(nums.length - 1, nums, new int[]{n, n, n, n});
    }

    private boolean dfs(int idx, int[] nums, int[] length) {
        if (idx < 0) {
            return length[0] == 0 && length[1] == 0 && length[2] == 0 && length[3] == 0;
        }
        for (int i = 0; i < length.length; i++) {
            if (nums[idx] > length[i]) {
                continue;
            }
            length[i] -= nums[idx];
            if (dfs(idx - 1, nums, length)) {
                return true;
            }
            length[i] += nums[idx];
        }
        return false;
    }
}
