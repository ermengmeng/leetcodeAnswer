
/**
 * @Author: ouyangyameng
 * @Date: 2023/1/10 18:32
 * @Version 1.0
 */
public class M264UglyNumber2 {

    public static void main(String[] args) {
    }

    public int nthUglyNumber(int n) {
        int index2 = 0, index3 = 0, index5 = 0;
        int[] array = new int[n];
        array[0] = 1;
        for (int i = 1; i < n; i++) {
            array[i] = Math.min(Math.min(array[index2] * 2, array[index3] * 3), array[index5] * 5);
            if (array[i] == array[index2] * 2) {
                index2++;
            }
            if (array[i] == array[index3] * 3) {
                index3++;
            }
            if (array[i] == array[index5] * 5) {
                index5++;
            }
        }
        return array[n-1];
    }
}
