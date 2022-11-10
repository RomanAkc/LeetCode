public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] grid = new char[][]{
                  {'1', '1', '1', '1', '0'}
                , {'1', '1', '0', '1', '0'}
                , {'1', '1', '0', '0', '0'}
                , {'0', '0', '0', '0', '0'}
        };
        System.out.println(s.numIslands(grid));

        grid = new char[][]{
                  {'1', '1', '0', '0', '0'}
                , {'1', '1', '0', '0', '0'}
                , {'0', '0', '1', '0', '0'}
                , {'0', '0', '0', '1', '1'}
        };
        System.out.println(s.numIslands(grid));
    }
}