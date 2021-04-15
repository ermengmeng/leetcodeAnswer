import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/15 7:30 下午
 * @Version 1.0
 */
public class ValidateStackSequences946 {

    public static void main(String[] args) {
        ValidateStackSequences946 o = new ValidateStackSequences946();
        System.out.print((o.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1})));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Set<Integer> pushSet = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0 ; i< popped.length; i++) {
            while (!pushSet.contains(popped[i]) && j <pushed.length) {
                stack.push(pushed[j]);
                pushSet.add(pushed[j++]);
            }
            if (!pushSet.contains(popped[i]) || stack.peek() != popped[i]) {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
