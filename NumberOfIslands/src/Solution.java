public class Solution {
    public int numIslands(char[][] grid) {
        int num_islands = 0;

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == '0') {
                    grid[i][j] = 'A';
                } else if(grid[i][j] == '1') {
                    checkAllIslandCells(i, j, grid);
                    num_islands++;
                }
            }
        }

        return num_islands;
    }

    void checkAllIslandCells(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;

        if(grid[i][j] == 'A')
            return;

        if(grid[i][j] == '0') {
            grid[i][j] = 'A';
            return;
        }

        if(grid[i][j] == '1') {
            grid[i][j] = 'A';
            checkAllIslandCells(i + 1, j, grid);
            checkAllIslandCells(i - 1, j , grid);
            checkAllIslandCells(i , j + 1, grid);
            checkAllIslandCells(i, j - 1, grid);
        }
    }




}
