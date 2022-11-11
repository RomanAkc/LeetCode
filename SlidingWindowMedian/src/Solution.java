import java.util.*;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int index = 0;

        int left = 0;
        int right = k;

        long[] arr = new long[k];
        while (right != nums.length + 1) {
            for(int i = left, j = 0; i < right; i++, j++) {
                arr[j] = nums[i];
            }
            Arrays.sort(arr);

            if(k%2 == 0) {
                long sum = arr[(k / 2)] + arr[(k / 2 - 1)];
                double d = (double)sum / 2.0;
                result[index++] = d;
            } else {
                double d = (double)arr[k/2];
                result[index++] = d;
            }

            left++;
            right++;
        }

        return result;
    }

    public double[] medianSlidingWindow_timeLimitExceeded(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int index = 0;

        int left = 0;
        int right = k;

        LinkedList<Long> list = new LinkedList<>();
        while (right != nums.length + 1) {
            if(left == 0) {
                for(int i = 0; i < right; i++) {
                    list.add((long)nums[i]);
                }
                list.sort(Long::compare);
            } else {
                for(int i = 0; i < list.size(); ++i) {
                    if(list.get(i) == nums[left - 1]) {
                        list.remove(i);
                        break;
                    }
                }

                int j = 0;
                for(; j < list.size(); ++j) {
                    if(list.get(j) > nums[right - 1]) {
                        list.add(j, (long)nums[right - 1]);
                        break;
                    }
                }

                if(j == list.size())
                    list.add((long)nums[right - 1]);
            }

            if(k%2 == 0) {
                long sum = list.get(k / 2) + list.get(k/2 - 1);
                double d = (double)sum / 2.0;
                result[index++] = d;
            } else {
                double d = (double)list.get(k/2);
                result[index++] = d;
            }

            left++;
            right++;
        }

        return result;
    }
}
