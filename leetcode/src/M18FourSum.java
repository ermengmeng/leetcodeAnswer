import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/20 1:58 下午
 * @Version 1.0
 */
public class M18FourSum {
    public static void main(String[] args) {
        M18FourSum o = new M18FourSum();
        System.out.println(o.fourSum(new int[]{}, 0));
    }


    //记录下所有两个数的和,再dp target - sum的解。最终以sort+set去重
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<int[]>> map = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (map.get(sum) == null) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new int[]{i, j});
                if (map.get(target - sum) != null) {
                    List<int[]> list = map.get(target - sum);
                    for (int k = 0; k < list.size(); k++) {
                        int[] ele = list.get(k);
                        if (ele[0] != i && ele[0] != j && ele[1] != i && ele[1] != j) {
                            List<Integer> resEle = Arrays.asList(nums[i], nums[j], nums[ele[0]], nums[ele[1]]);
                            Collections.sort(resEle);
                            res.add(resEle);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    //网上的方法略快一点 定位剪枝
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Set<List<Integer> > set = new HashSet<>();
        Arrays.sort(nums);

        //多套了一层循环的3sum
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int left = j+1;
                int right = nums.length-1;

                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];

                    //与closet不同，直接遍历到target需要继续夹逼寻找所有解
                    if(sum==target) {
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }

                    else if(sum<target) left++;

                    else if(sum>target) right--;

                }

            }

        }

        return new ArrayList<>(set);
    }
}
