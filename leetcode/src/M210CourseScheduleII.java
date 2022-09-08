import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/8/4 14:03
 * @Version 1.0
 */
public class M210CourseScheduleII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new M210CourseScheduleII().findOrder(3, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}})));
        System.out.println(Arrays.toString(new M210CourseScheduleII().findOrder(2, new int[][]{new int[]{1, 0}})));
        System.out.println(Arrays.toString(new M210CourseScheduleII().findOrder(2, new int[][]{new int[]{0, 1}, new int[]{1, 0},})));
    }

    int i = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<>());
        }
        for (int[] prerequisity : prerequisites) {
            adj.get(prerequisity[0]).add(prerequisity[1]);
        }
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycVisit = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (visit.contains(i)) {
                continue;
            }
            if (doSchedule(i, adj, visit, cycVisit, res)) {
                cycVisit = new HashSet<>();
            } else {
                return new int[0];
            }
        }
        return res;
    }


    private boolean doSchedule(int courses, List<List<Integer>> adj, Set<Integer> visit, Set<Integer> cycVisit, int[] res) {
        List<Integer> prerequireList = adj.get(courses);
        visit.add(courses);
        cycVisit.add(courses);
        for (Integer prerequire : prerequireList) {
            Set<Integer> curVisit = new HashSet<>(cycVisit);
            if (curVisit.contains(prerequire)) {
                return false;
            }
            if (visit.contains(prerequire)) {
                continue;
            }
            if (!doSchedule(prerequire, adj, visit, curVisit, res)) {
                return false;
            }
        }
        res[i++] = courses;
        return true;
    }
}
