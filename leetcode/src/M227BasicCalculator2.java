import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/9 14:30
 * @Version 1.0
 */
public class M227BasicCalculator2 {

    public static void main(String[] args) {
        System.out.println(new M227BasicCalculator2().calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    /**
     * 先乘除后加减
     * 使用stack,处理遇到乘除优先pop出前一个数据做运算之后push
     * 减法处理为+负数。
     * 最后将stack中的数据相加得到答案
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = s.replace(" ", "");
        String[] nums = s.split("\\+|-|\\*|/");
        List<Long> numList = new ArrayList<>();
        List<Character> signList = new ArrayList<>();
        int site = 0;
        int index = 0;
        site+=nums[index].length();
        numList.add(Long.valueOf(nums[index++]));
        while (site < s.length() && index < nums.length) {
            char c = s.charAt(site);
            site+=nums[index].length() + 1;
            if (c == '+' || c == '-') {
                signList.add(c);
                numList.add(Long.valueOf(nums[index++]));
            } else if (c == '*') {
                Long temp = numList.get(numList.size() - 1) * Long.valueOf(nums[index++]);
                numList.set(numList.size() - 1, temp);
            } else if (c == '/') {
                Long temp = numList.get(numList.size() - 1) / Long.valueOf(nums[index++]);
                numList.set(numList.size() - 1, temp);
            }
        }
        int i = 0;
        int j = 0;
        Long result = numList.get(i++);
        while (j < signList.size()) {
            Character c = signList.get(j++);
            if (c == '+') {
                result+=numList.get(i++);
            }
            if (c == '-') {
                result-=numList.get(i++);
            }
        }
        return result.intValue();
    }


    public int calculate2(String s) {
        Stack<Integer> st=new Stack<>();
        char sign='+';
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(Character.isDigit(x)){
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num=num*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    st.push(num);
                }
                else if(sign=='-'){
                    st.push(-num);
                }
                else if(sign=='*'){
                    st.push(st.pop()*num);
                }
                else if(sign=='/'){
                    st.push(st.pop()/num);
                }
            }
            else if(x=='+'){
                sign='+';
            }
            else if(x=='-'){
                sign='-';
            }
            else if(x=='*'){
                sign='*';
            }
            else if(x=='/'){
                sign='/';
            }
            else{
                continue;
            }
        }

        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }

        return sum;
    }
}
