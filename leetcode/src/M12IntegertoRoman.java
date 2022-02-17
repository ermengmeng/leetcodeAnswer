/**
 * @Author: ouyangyameng
 * @Date: 2021/6/30 1:23 下午
 * @Version 1.0
 */
public class M12IntegertoRoman {
    public static void main(String[] args) {
        M12IntegertoRoman o = new M12IntegertoRoman();
        System.out.println(o.intToRoman(4));
    }

    public String intToRoman(int num) {
        char[][] table = new char[][]{new char[]{'I','V','X','I'}, new char[]{'X','L','C','X'}, new char[]{'C','D','M','C'}, new char[]{'M','M','M','M'}};
        String res = "";
        for (int i = 0; i < String.valueOf(num).length(); i++) {
            char c = String.valueOf(num).toCharArray()[i];
            res+=dealCur(c-'0', table[String.valueOf(num).length()-1-i]);
        }
        return res;
    }

    private String dealCur(int cur, char[] table) {
        String res = "";
        if (cur == 0) {

        } else if (cur<4) {
            for (int i = 0; i< cur; i++) {
                res+=table[0];
            }
        } else if (cur == 4) {
            res+="" + table[3]+ table[1];
        } else if (cur == 9) {
            res+="" + table[3] + table[2];
        } else {
            res += table[1];
            for(int i = 0;i < cur -5 ;i++) {
                res+=table[0];
            }
        }
        return res;
    }

}
