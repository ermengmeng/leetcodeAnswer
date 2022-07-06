import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/5 18:58
 * @Version 1.0
 */
public class M166FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(new M166FractionToRecurringDecimal().fractionToDecimal(-2,1));
    }

    /**
     * 处理int计算问题时注意值域 -2^31 <= num <= 2^31 - 1
     * 在符号变换时的溢出问题。
     * 比较常见的处理方式是转换成long处理。整体代码逻辑会比较清晰。
     * 另外在拼字符串时，尽量在计算过程中添加到StringBuilder中。
     * 在得出结果后再拼接会损失很多性能。
     * ps.StringBuilder的insert有点意思。
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNagetive = (numerator ^ denominator) < 0;
        long numeratorLong = Math.abs((long)numerator);
        long denominatorLong = Math.abs((long)denominator);
        long num = numeratorLong / denominatorLong;
        long remain = numeratorLong % denominatorLong;
        Map<Long,Integer> cache = new HashMap<>();
        if (isNagetive) {
            sb.append("-");
        }
        sb.append(num);
        if (remain > 0) {
            sb.append(".");
        }
        while (remain > 0) {
            if (cache.containsKey(remain)) {
                int len = cache.get(remain);
                sb.insert(len,"(");
                sb.append(")");
                break;
            } else {
                cache.put(remain, sb.length());
                if (remain < denominatorLong) {
                    remain *= 10;
                }
                Long single = remain / denominatorLong;
                remain %= denominatorLong;
                sb.append(single);
            }
        }
        return sb.toString();
    }


    public String fractionToDecimalSecond(int numerator, int denominator) {

        if(numerator == 0)
            return "0";

        StringBuilder res = new StringBuilder();

        if(numerator < 0 ^ denominator < 0)
            res.append("-");

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        long q = n / d;
        long r = n % d;
        res.append(q);

        if(r == 0)
            return res.toString();
        else{
            res.append(".");

            HashMap<Long, Integer> map = new HashMap<>();

            while(r != 0) {
                if(map.containsKey(r)){
                    int len = map.get(r);
                    res.insert(len,"(");
                    res.append(")");
                    break;
                }else{
                    map.put(r,res.length());
                    r = r * 10;
                    q = r / d;
                    r = r % d;
                    res.append(q);
                }
            }
        }
        return res.toString();
    }
}
