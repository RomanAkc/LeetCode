import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i  = 0; i < nums.length; ++i) {
            if(i >= k) {
                int x = deque.peekFirst();
                result[i - k] = x;
                if(x == nums[i - k]) {
                    deque.pollFirst();
                }
            }

            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }

        if(!deque.isEmpty() && nums.length >= k) {
            result[result.length - 1] = deque.peekFirst();
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
