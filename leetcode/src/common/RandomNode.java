package common;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/21 18:36
 * @Version 1.0
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
