import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; ++i) {
            var val = target - nums[i];
            if(map.containsKey(val) && map.get(val) != i)
                return new int[] {i, map.get(val)};
        }

        return null;
    }

    public int[] twoSum_old(int[] nums, int target) {
        int result [] = new int[2];
        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }

            }
        }
        return result;
    }
}
