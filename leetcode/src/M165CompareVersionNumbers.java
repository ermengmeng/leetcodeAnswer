/**
 * @Author: ouyangyameng
 * @Date: 2022/7/5 09:48
 * @Version 1.0
 */
public class M165CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(new M165CompareVersionNumbers().compareVersion("10.4.9","104.9"));
    }

    /**
     * 字符串的题没什么难度,就是处理时候要小心考虑0的位置
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int i1 = 0, i2 = 0;
            if (i < v1.length) {
               i1 = convertInt(v1[i]);
            }
            if (i < v2.length) {
               i2 = convertInt(v2[i]);
            }
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
        }
        return 0;
    }

    private int convertInt(String str) {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '0') {
                i++;
            } else {
                break;
            }
        }
        return i == str.length() ? 0 : Integer.valueOf(str.substring(i));
    }
}
