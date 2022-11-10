public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, -1));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 0));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 3));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 5));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 12));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 10));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, -5));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, 100));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12}, -2));
    }
}