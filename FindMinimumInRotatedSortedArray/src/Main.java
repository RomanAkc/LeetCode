public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{1,2,3,4,5}));
        System.out.println(s.findMin(new int[]{5,1,2,3,4}));
        System.out.println(s.findMin(new int[]{4,5,1,2,3}));
        System.out.println(s.findMin(new int[]{3,4,5,1,2}));
        System.out.println(s.findMin(new int[]{2,3,4,5,1}));
        System.out.println(s.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(s.findMin(new int[]{11,13,15,17}));
        System.out.println(s.findMin(new int[]{17,11,13,15}));
        System.out.println(s.findMin(new int[]{15,17,11,13}));
        System.out.println(s.findMin(new int[]{13,15,17,11}));
        System.out.println(s.findMin(new int[]{-5,-4,-3,-2,-1}));
        System.out.println(s.findMin(new int[]{-1,-5,-4,-3,-2}));
        System.out.println(s.findMin(new int[]{-2,-1,-5,-4,-3}));
        System.out.println(s.findMin(new int[]{-3,-2,-1,-5,-4}));
        System.out.println(s.findMin(new int[]{-4,-3,-2,-1,-5}));
    }
}