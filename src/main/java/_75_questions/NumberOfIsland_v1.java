package _75_questions;

public class NumberOfIsland_v1 {
    // TODO enhancement pls
    public int numIslands(char[][] grid) {
        int rs = 0;
        for(int c = 0; c < grid[0].length; c++ ) {
            for(int r = 0; r < grid.length; r++) {
                char current = grid[c][r];
                if(current == '0' || current == 'x') {
                    continue;
                } else {
                    rs++;
                    numIslandsHelper(grid,c,r);
                }
            }
        }
        return rs;
    }
    public void numIslandsHelper(char[][] grid, int c, int r) {
        if(c >= grid[0].length || r >= grid.length) {
            return;
        }
        char current = grid[c][r];
        if(current == '0' || current == 'x') {
            return;
        }
        grid[c][r] = 'x';
        numIslandsHelper(grid,c+1,r);
        numIslandsHelper(grid,c,r+1);
    }
}