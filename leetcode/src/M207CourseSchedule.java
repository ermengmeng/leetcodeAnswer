import java.util.ArrayList;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/19 19:00
 * @Version 1.0
 */
public class M207CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new M207CourseSchedule().canFinish(10, new int[][]{new int[]{7, 3}, new int[]{3, 6}, new int[]{6, 4}, new int[]{4, 5}}));
    }

    //将前置规则处理为, A -> List（B）的形式
    //BFS遍历所有的课程
    //再每一个课程上DFS规则,查看是否存在循环依赖。以dfsvis表示在一个课程上已经访问过的课程。如果dfs过程中dfsvis存在已访问节点。则代表子节点依赖父节点形成循环依赖。
    //使用vis记录在dfs过程中已经处理过的节点。在bfs中不用重复处理。
    //PS.由于规则存在一对多或者多对一的关系。所以遍历规则不是很好的选择。
    public boolean canFinish(int numCourses, int[][] pre) {
        int[] vis = new int[numCourses];
        int[] dfsvis = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < pre.length; i++) {
            adj.get(pre[i][0]).add(pre[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (checkCycle(vis, dfsvis, i, adj)) return false;
            }
        }
        return true;
    }

    public boolean checkCycle(int[] vis, int[] dfsvis, int node, ArrayList<ArrayList<Integer>> adj) {
        // vis[node] = 1;   -> dfs
        // dfsvis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                vis[node] = 1;    //-> bfs
                dfsvis[node] = 1;
                if (checkCycle(vis, dfsvis, i, adj)) return true;
            } else if (dfsvis[i] != 0) return true;
        }
        dfsvis[node] = 0;
        return false;
    }
}
