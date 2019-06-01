package structure;

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

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (!numsMap.containsKey(sub)) {
                numsMap.put(sub,i);
            }
        }
        return null;
    }
}
