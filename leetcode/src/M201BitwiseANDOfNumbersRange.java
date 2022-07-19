/**
 * @Author: ouyangyameng
 * @Date: 2022/7/15 18:44
 * @Version 1.0
 */
public class M201BitwiseANDOfNumbersRange {
    /**
     * 将32位与不断分解为低位与的简单问题
     * 如果两个数不相等，那么他们中间的数低位必定存在0，所以低位为0。
     * 通过不断左移判断，如果不相等，那么左移的那位与必为0。如果相等,代表范围内所有数高位相同，与的结果也相同
     * 最终通过左移的位数在进行右移补0得到结果
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int zeros = 0;
        while (right > left) {
            zeros++;
            left >>>= 1;
            right >>>= 1;
        }
        return left << zeros;
    }
}
