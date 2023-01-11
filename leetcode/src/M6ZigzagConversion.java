/**
 * @Author: ouyangyameng
 * @Date: 2022/2/21 7:53 下午
 * @Version 1.0
 */
public class M6ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(new M6ZigzagConversion().convert("PAYPALISHIRING", 2));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int[] rowIndex = new int[numRows + 1];
        int indexNum = (numRows - 1) * 2;
        int base = chars.length / indexNum;
        int other = chars.length % indexNum;
        rowIndex[1] = base + (other > 0 ? 1 : 0);
        for (int i = 2; i <= numRows; i++) {
            if (i == numRows) {
                rowIndex[i] = base + (i - 1 < other ? 1 : 0);
            } else {
                rowIndex[i] = base + (i - 1 < other ? 1 : 0);
                rowIndex[i] += base + ((indexNum - i + 1) < other ? 1 : 0);
            }
            rowIndex[i] += rowIndex[i - 1];
        }

        for (int i = 0; i < chars.length; i++) {
            int site = i % indexNum;
            if (site > numRows - 1) {
                site = indexNum - site;
            }
            result[rowIndex[site]++] = chars[i];
        }
        return new String(result);
    }
}
