/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 10:40
 * @Version 1.0
 */
public class M275HIndex2 {

    public static void main(String[] args) {
        System.out.println(new M275HIndex2().hIndex(new int[]{1,2,3,5,6}));
    }

    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int h = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int citation = citations[mid];
            if (citation < citations.length - mid) {
                h = Math.max(citation, h);
                start = mid + 1;
            } else if (citation > 0) {
                h = Math.max(h, citations.length - mid);
                end = mid -1;
            } else {
                break;
            }
        }
        return h;
    }
}
