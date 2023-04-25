/**
 * @Author: ouyangyameng
 * @Date: 2023/1/19 16:05
 * @Version 1.0
 */
public class M274HIndex {
    public static void main(String[] args) {
        System.out.println(new M274HIndex().hIndex(new int[]{0}));
    }

    public int hIndex(int[] citations) {
        int h = 0;
        int[] count = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                count[citations.length]++;
            } else {
                count[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = citations.length; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return h;
    }
}
