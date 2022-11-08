public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(s.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(s.maxProfit(new int[]{7, 1, 11}));
        System.out.println(s.maxProfit(new int[]{1, 7, 11}));
        System.out.println(s.maxProfit(new int[]{1, 11, 7}));
        System.out.println(s.maxProfit(new int[]{11, 1, 7}));
        System.out.println(s.maxProfit(new int[]{7, 11, 1}));
    }
}