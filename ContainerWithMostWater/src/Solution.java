public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
    public int maxArea_optimize(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; ++i) {
            if(height[i] == 0)
                continue;

            int j;
            if(max == 0) {
                j = i + 1;
            } else {
                j = ((max / height[i]) + i);
            }

            for(; j < height.length; ++j) {
                int square = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, square);
            }
        }
        return max;
    }

    public int maxArea_quadratic(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; ++i) {
            for(int j = i + 1; j < height.length; ++j) {
                int square = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, square);
            }
        }
        return max;
    }
}
