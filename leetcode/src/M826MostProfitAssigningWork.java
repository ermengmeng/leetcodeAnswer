import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: ouyangyameng
 * @Date: 2021/5/18 2:00 下午
 * @Version 1.0
 */
public class M826MostProfitAssigningWork {
    public static void main(String[] args) {
        M826MostProfitAssigningWork o = new M826MostProfitAssigningWork();
        System.out.println(o.maxProfitAssignment(new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Task[] taskArray = new Task[difficulty.length];
        for (int i = 0; i< difficulty.length; i++) {
            Task t = new Task();
            t.difficulty = difficulty[i];
            t.profit = profit[i];
            taskArray[i] = t;
        }
        Arrays.sort(taskArray, (Comparator.comparingInt(t -> t.difficulty)));
        int k = 0;
        int sum = 0;
        int curMax = 0;
        Arrays.sort(worker);
        for (int i = 0; i< worker.length; i++) {
            while (k < taskArray.length && taskArray[k].difficulty<=worker[i]) {
                curMax = Math.max(curMax, taskArray[k].profit);
                k++;
            }
            sum += curMax;
        }
        return sum;
    }

    public class Task {
        int difficulty;
        int profit;
    }
}
