import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{7,11,15,2}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{11,15,2,7}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{7,11,2,15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,3}, 6)));
    }


}