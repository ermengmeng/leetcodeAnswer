import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/27 13:46
 * @Version 1.0
 */
public class M150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(new M150EvaluateReversePolishNotation().evalRPN(new String[] {"4","13","5","/","+"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s :tokens) {
            switch (s) {
                case "+" :
                    Integer res = stack.pop() + stack.pop();
                    stack.push(res);
                    break;
                case "-" :
                    Integer i2 = stack.pop();
                    Integer i1 = stack.pop();
                    res = i1 - i2;
                    stack.push(res);
                    break;
                case "*" :
                    res = stack.pop() * stack.pop();
                    stack.push(res);
                    break;
                case "/" :
                    i2 = stack.pop();
                    i1 = stack.pop();
                    res = i1 / i2;
                    stack.push(res);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
