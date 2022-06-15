/**
 * @Author: ouyangyameng
 * @Date: 2022/6/15 10:20
 * @Version 1.0
 */
public class M122BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                sum+=prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}
