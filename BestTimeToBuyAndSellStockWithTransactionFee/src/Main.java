public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println(s.maxProfit(new int[]{1,3,7,5,10,3}, 3));
        System.out.println(s.maxProfit(new int[]{1}, 0));
        System.out.println(s.maxProfit(new int[]{2,1,4,4,2,3,2,5,1,2}, 1));
        System.out.println(s.maxProfit(new int[]{2,1,4,2,5,1,2}, 1));
    }
}