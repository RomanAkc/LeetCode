import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 1)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 2)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 4)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{2147483647, 2147483646, 2147483645, 2147483644}, 2)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,2,3,4,2,3,1,4,2}, 3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4)));
    }
}