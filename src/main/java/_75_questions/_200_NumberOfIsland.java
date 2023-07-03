package _75_questions;

public class _200_NumberOfIsland {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++ ) {
                if(grid[r][c] != 'x' && grid[r][c] == 1) {
                    int tempMax = helper(grid,m,n,r,c);
                    max = Math.max(max, tempMax);
                }
            }
        }
        return max;
    }

    private int helper(char[][] grid,int m, int n, int r, int c) {
        if(r < 0 || c < 0 || r >= m || c >= n) {
            return 0;
        }
        if(grid[r][c] == '0' || grid[r][c] == 'x') {
            return 0;
        }
        grid[r][c] = 'x';
        return 1 + helper(grid,m,n,r+1, c)
                 + helper(grid,m,n,r-1, c)
                 + helper(grid,m,n,r ,c+1)
                 + helper(grid,m,n,r, c-1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++ ) {
                if(grid[r][c] == 1) {
                    int tempMax = helper(grid,m,n,r,c);
                    max = Math.max(max, tempMax);
                }
            }
        }
        return max;
    }

    private int helper(int[][] grid,int m, int n, int r, int c) {
        if(r < 0 || c < 0 || r >= m || c >= n) {
            return 0;
        }
        if(grid[r][c] == 0 || grid[r][c] == -1) {
            return 0;
        }
        grid[r][c] = -1;
        return 1 + helper(grid,m,n,r+1,c)
                + helper(grid,m,n,r-1,c)
                + helper(grid,m,n,r,c+1)
                + helper(grid,m,n,r,c-1);
    }
}