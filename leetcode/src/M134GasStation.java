/**
 * @Author: ouyangyameng
 * @Date: 2022/6/20 18:12
 * @Version 1.0
 */
public class M134GasStation {
    public static void main(String[] args) {
        System.out.println(new M134GasStation().canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
    }

    /**
     * 动态规划
     * 1.如果cost整体和大于gas,那么一定不能到达
     * 2.得到某一站的净补充(gas[i]-cost[i])
     * 3.从0开始如果净补充一直不小于0,代表可以开到最后
     * 4.如果净补充和存在负值，那么从净补充和最小的那站的下一站开始循环可以到达
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemain = 0;
        int minRemain = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            if (minRemain > sumRemain + remain) {
                minRemain = sumRemain + remain;
                start = i;
            }
            sumRemain+=remain;
        }
        if (sumRemain < 0) {
            return -1;
        } else if (minRemain == 0) {
            return 0;
        } else {
            return (start + 1) % gas.length;
        }
    }
}
