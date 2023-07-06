/**
 * @Author: ouyangyameng
 * @Date: 2022/2/14 4:42 下午
 * @Version 1.0
 */
public class M45JumpGame2 {
    public static void main(String[] args) {
        M45JumpGame2 o = new M45JumpGame2();
        System.out.println(o.jump(new int[]{2, 3, 0, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int[] res = new int[nums.length];
        res[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            int min = Integer.MAX_VALUE - 1;
            for (int j = i + 1; j <= i + step && j < nums.length; j++) {
                min = Math.min(min, res[j] + 1);
            }
            res[i] = min;
        }
        return res[0];
    }


    //由于DP并不能从res[i+1】直接推出res[i]而是需要遍历后面所有的解，寻找最小的
    //所以选用贪心,找出一步跳的范围内,下一步可以跳的最大的节点。
    //最终得出最优路径
    public int jump2(int[] nums) {
        int max_i = 0;
        int steps = 0;
        int count = nums[0];
        int i = 0;

        if(nums.length == 1) {
            return 0;
        }

        while(i < nums.length) {
            if(count >= nums.length - (i + 1)) {
                steps++;
                break;
            }

            max_i = max(nums, i+1, i + nums[i]+1);

            i = max_i;

            count = nums[i];
            steps++;

        }

        return steps;
    }
    public int max(int[] arr, int start, int end) {
        int max = arr[start];
        int index = 0;
        while(start < end) {
            if(max <= arr[start] + start) {
                max = arr[start] + start;
                index = start;
            }
            start++;
        }
        return index;
    }
}
