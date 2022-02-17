import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/26 6:54 下午
 * @Version 1.0
 */
public class M1209RemoveAllAdjacentDuplicatesinStringII {
    public static void main(String[] args) {
        M1209RemoveAllAdjacentDuplicatesinStringII o = new M1209RemoveAllAdjacentDuplicatesinStringII();
        System.out.println(o.removeDuplicates("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        char[] array = s.toCharArray();
        int site = 1;
        Stack<Item> stack = new Stack<>();
        stack.push(new Item('A', 0));
        Item cur = new Item(array[0], 1);
        for (int i = 1; i < array.length; i++) {
            char c = array[i];
            array[site] = c;
            if (c != cur.c) {
                stack.push(cur);
                cur = new Item(c, 1);
            } else {
                cur.num++;
                if (cur.num == k) {
                    site -= k;
                    cur = stack.pop();
                }
            }
            site++;
        }
        return new String(Arrays.copyOfRange(array, 0, site));
    }

    class Item {
        char c;
        int num;

        public Item(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
}
