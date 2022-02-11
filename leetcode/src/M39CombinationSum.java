import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/11 2:49 下午
 * @Version 1.0
 */
public class M39CombinationSum {
    public static void main(String[] args) {
        M39CombinationSum o = new M39CombinationSum();
        System.out.println(o.combinationSum(new int[]{2, 3, 6, 7}, 1));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        Arrays.sort(candidates);
        computeSum(candidates, target, map);
        List<int[]> list = map.get(target);
        List<List<Integer>> result = new ArrayList<>();
        for (int[] array : list) {
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i]; j++) {
                    item.add(candidates[i]);
                }
            }
            result.add(item);
        }
        return result;
    }

    private void computeSum(int[] candidates, int target, Map<Integer, List<int[]>> map) {
        map.putIfAbsent(target, new ArrayList<>());
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            if (target == candidates[i]) {
                int[] array = new int[candidates.length];
                array[i] += 1;
                map.get(target).add(array);
            } else {
                if (map.get(target - candidates[i]) == null) {
                    computeSum(candidates, target - candidates[i], map);
                }

                for (int[] array : map.get(target - candidates[i])) {
                    int[] copy = Arrays.copyOf(array, candidates.length);
                    copy[i] += 1;
                    String str = Arrays.toString(copy);
                    if (!tmp.contains(str)) {
                        tmp.add(str);
                        map.get(target).add(copy);
                    }
                }
            }
        }
    }


    /**
     * 别人的回溯法
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumAnswer(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<candidates.length;i++){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(candidates[i]);
            helper(a,target-candidates[i],candidates,i,ans);
        }

        return ans;
    }

    public void helper(ArrayList<Integer> a,int tar,int[] c,int k,List<List<Integer>> ans){
        if(tar <=0){
            if(tar == 0){
                ans.add(new ArrayList<>(a));
            }
            return;
        }

        for(int i = k;i<c.length;i++){
            a.add(c[i]);
            helper(a,tar-c[i],c,i,ans);
            a.remove(a.size()-1);
        }
    }
}
