import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/13 12:09 下午
 * @Version 1.0
 */
public class M1734DecodeXORedPermutation {
    public static void main(String[] args) {
        M1734DecodeXORedPermutation o = new M1734DecodeXORedPermutation();
        System.out.print(Arrays.toString(o.decode(new int[]{6,5,4,6})));
    }
    public int[] decode(int[] encoded) {
        int[] src = new int[encoded.length+1];
        int xorSum = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            xorSum ^= i;
        }
        for (int i = 0; i < encoded.length; i = i+2) {
            xorSum ^= encoded[i+1];
        }
        src[0] = xorSum;
        for (int i = 1; i < src.length; i++) {
            src[i] = encoded[i-1] ^ src[i-1];
        }
        return src;
    }
}
