/**
 * @Author: ouyangyameng
 * @Date: 2021/11/16 1:39 下午
 * @Version 1.0
 */
public class M38CountAndSay {
    public static void main(String[] args) {
        System.out.println(new M38CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n-1);
        char[] array = say.toCharArray();
        char cur = array[0];
        int num = 1;
        String res = "";
        for (int i = 1; i< array.length; i++) {
            if (array[i] == cur) {
                num++;
            } else {
                res +=  String.valueOf(num) + (cur - '0') ;
                num = 1;
                cur = array[i];
            }
        }
        if (num > 0) {
            res +=  String.valueOf(num) + (cur - '0') ;
        }
        return res;
    }
}
