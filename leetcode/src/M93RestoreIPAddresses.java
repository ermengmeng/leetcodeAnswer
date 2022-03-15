import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/14 9:45 上午
 * @Version 1.0
 */
public class M93RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(new M93RestoreIPAddresses().restoreIpAddresses("2736786374048"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        restore(res, cur, s.toCharArray(), 0);
        return res;
    }

    public void restore(List<String> res, LinkedList<Integer> cur, char[] ip, int index) {
        if (cur.size() == 3) {
            if (index < ip.length) {
                int segment = 0;
                for (int i = index; i < ip.length; i++) {
                    segment = segment * 10 + (ip[i] - '0');
                }
                if (segment >= 0 && segment <= 255 && !(ip[index] == '0' && ip.length - index > 1)) {
                    res.add((new String(Arrays.copyOfRange(ip, 0, cur.get(0))) + "." +
                            new String(Arrays.copyOfRange(ip, cur.get(0), cur.get(1))) + "." +
                            new String(Arrays.copyOfRange(ip, cur.get(1), cur.get(2))) + "." +
                            new String(Arrays.copyOfRange(ip, cur.get(2), ip.length))));
                }
            }
            return;
        }
        int segment = 0;
        for (int i = 1; i <= 3 && i < ip.length - index; i++) {
            segment = segment * 10 + (ip[index + i - 1] - '0');
            if (segment <= 255) {
                cur.add(index + i);
                restore(res, cur, ip, index + i);
                cur.removeLast();
            }
            if (segment == 0) {
                break;
            }
        }
    }
}
