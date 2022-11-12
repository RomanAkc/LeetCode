import java.util.ArrayDeque;
import java.util.TreeMap;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int max = nums[0];
        int max_prev = nums[0];

        for(int i = 0; i <= nums.length; i++) {
            if(i >= k) {
                result[i - k] = max;
                int removed = deq.remove();
                if(removed == max) {
                    max = max_prev;
                }
            }

            if(i < nums.length) {
                deq.add(nums[i]);
                if(nums[i] > max) {
                    max_prev = max;
                    max = nums[i];
                }
            }
        }

        return result;
    }

    public int[] maxSlidingWindow_slow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i <= nums.length; i++) {
            if(i >= k) {
                result[i - k] = map.lastKey();
                int newVal = map.get(nums[i - k]);
                newVal--;
                if(newVal == 0)
                    map.remove(nums[i - k]);
                else
                    map.replace(nums[i - k], newVal);
            }

            if(i < nums.length) {
                int newVal = 0;
                if(map.containsKey(nums[i]))
                    newVal = map.get(nums[i]);
                map.put(nums[i], ++newVal);
            }
        }

        return result;
    }
}
