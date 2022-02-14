import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/11 3:55 下午
 * @Version 1.0
 */
public class M40CombinationSum2 {
    public static void main(String[] args) {
        M40CombinationSum2 o = new M40CombinationSum2();
        System.out.println(o.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, List<int[]>> map = new HashMap<>();


        Map<Integer, Integer> candidateMap = new HashMap<>();
        Arrays.stream(candidates).forEach(i -> {
            if (candidateMap.get(i) == null) {
                candidateMap.put(i, 1);
            } else {
                candidateMap.put(i, candidateMap.get(i) + 1);
            }
        });
        int[] c = new int[candidateMap.size()];
        int[] s = new int[candidateMap.size()];
        int i = 0;
        Iterator<Integer> iterator = candidateMap.keySet().iterator();
        while (iterator.hasNext()) {
            c[i] = iterator.next();
            i++;
        }
        Arrays.sort(c);
        for (int j = 0; j < c.length; j++) {
            s[j] = candidateMap.get(c[j]);
        }
        computeSum(c, s, target, map);


        List<int[]> list = map.get(target);
        List<List<Integer>> result = new ArrayList<>();
        for (int[] array : list) {
            List<Integer> item = new ArrayList<>();
            for (int k = 0; k < array.length; k++) {
                for (int j = 0; j < array[k]; j++) {
                    item.add(c[k]);
                }
            }
            result.add(item);
        }
        return result;
    }

    private void computeSum(int[] candidates, int[] size, int target, Map<Integer, List<int[]>> map) {
        map.putIfAbsent(target, new ArrayList<>());
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            if (target == candidates[i]) {
                int[] array = new int[candidates.length];
                array[i] += 1;
                if (array[i] <= size[i]) {
                    map.get(target).add(array);
                }
            } else {
                if (map.get(target - candidates[i]) == null) {
                    computeSum(candidates, size, target - candidates[i], map);
                }
                for (int[] array : map.get(target - candidates[i])) {
                    int[] copy = Arrays.copyOf(array, candidates.length);
                    copy[i] += 1;
                    String str = Arrays.toString(copy);
                    if (copy[i] <= size[i] && !tmp.contains(str)) {
                        tmp.add(str);
                        map.get(target).add(copy);
                    }
                }
            }
        }
    }


    public List<List<Integer>> combinationSum2Other(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);

        compute(list, candidates, 0, target, result);
        return new ArrayList<>(result);
    }

    private void compute(List<Integer> list, int[] c, int k, int t, Set<List<Integer>> ans) {
        if (t == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (k == c.length || t < 0) {
            return;
        }
        for (int i = k; i < c.length; i++) {
            list.add(c[i]);
            compute(list, c, i + 1, t - c[i], ans);
            list.remove(list.size() - 1);
        }
    }
}
