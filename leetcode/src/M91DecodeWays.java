/**
 * @Author: ouyangyameng
 * @Date: 2022/3/2 6:33 下午
 * @Version 1.0
 */
public class M91DecodeWays {
    public static void main(String[] args) {
        System.out.println(new M91DecodeWays().numDecodings("1123"));
    }

    //使用数组memo记录memo[i]为从i位开始到末尾可能的解码数量
    //充分拆解DP条件则有以下几种方式
    //1.如果i本身为0,那么从i位开始,不存在任何解码的可能。
    //2.如果i本身不为0,则i本身至少可以单独作为一个数字,一次从i位开始就有memo[i+1]种可能
    //3.如果和后面的数字组合起来<=26则可以组合起来算。这样又可以产生memo[i+2]种可能
    //memo[0]即为最终解
    //可见dp只和i+1和i+2的值有关。
    //因此简化为为currentWays,prev,prevprev三个变量
    //设定初始循环条件,从后向前循环,得到最终解
    public int numDecodings(String s) {
        int n = s.length();
        int prev = 1;
        int prevprev = 1;
        for(int i = n - 1; i >= 0; i--) {
            int currentWays = 0;
            if(s.charAt(i) != '0') {
                currentWays = prev;
            }
            if (s.charAt(i) == '1' && i + 1 != s.length()) {
                currentWays += prevprev;
            } else if (s.charAt(i) == '2'  && i + 1 != s.length() && s.charAt(i + 1) - '0' <= 6) {
                currentWays += prevprev;
            }
            prevprev = prev;
            prev = currentWays;
        }
        return prev;
    }
}
