public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] arr = new int[][]{{1,3,5,7},{0,11,16,20},{23,30,34,60}};
        System.out.println(s.searchMatrix(arr, 3));
        System.out.println(s.searchMatrix(arr, 13));

        int[][] arr2 = new int[][]{{1,1}};
        System.out.println(s.searchMatrix(arr2, 2));
        System.out.println(s.searchMatrix2(arr2, 0));
    }
}