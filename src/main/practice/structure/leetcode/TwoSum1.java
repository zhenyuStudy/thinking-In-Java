package structure.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {



    //暴力法
    public int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == (target - nums[i])) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //两遍哈希表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement) && complement != nums[i]) {
                return new int[]{i, numsMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //一遍哈希表
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum1 solution = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum3(nums, target)));
    }
}
