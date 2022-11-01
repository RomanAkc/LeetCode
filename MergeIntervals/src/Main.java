import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        showArray(s.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        showArray(s.merge(new int[][]{{8,10},{15,18},{2,6},{1,3}}));
        showArray(s.merge(new int[][]{{2,2},{1,1}}));
        showArray(s.merge(new int[][]{{1,4},{4,5}}));
        showArray(s.merge(new int[][]{{4,5},{1,4}}));
        showArray(s.merge(new int[][]{{2,2},{2,2}}));
        showArray(s.merge(new int[][]{{2,3},{2,3}}));
        showArray(s.merge(new int[][]{{1,4},{2,3}}));
        showArray(s.merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}}));
    }

    private static void showArray(int[][] arr) {
        System.out.print("[");
        for(var v : arr) {
            System.out.print(Arrays.toString(v));
            System.out.print(",");
        }
        System.out.println("]");
    }
}