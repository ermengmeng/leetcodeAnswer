import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/19 14:46
 * @Version 1.0
 */
public class M1306JumpGame3 {

    public static void main(String[] args) {
        System.out.println(new M1306JumpGame3().canReach(new int[]{4,2,3,0,3,1,2}, 5));
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Stack<Integer> cache = new Stack();
        cache.add(start);
        visited[start] = true;
        while (!cache.isEmpty()) {
            Integer cur = cache.pop();
            if (arr[cur] == 0) {
                return true;
            }
            if (cur - arr[cur] >= 0 && !visited[cur - arr[cur]]) {
                visited[cur - arr[cur]] = true;
                cache.push(cur - arr[cur]);
            }
            if (cur + arr[cur] < arr.length && !visited[cur + arr[cur]]) {
                visited[cur + arr[cur]] = true;
                cache.push(cur + arr[cur]);
            }
        }
        return false;
    }
}
