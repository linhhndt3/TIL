package _75_questions;

import java.util.*;

public class PacificAlanticWaterFlow_v2 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> rs = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] alantic = new boolean[m][n];
        int[][] dir = new int[][]{{0,1},{0,-1}, {1,0},{-1,0}}; //TODO great idea because ...

        for(int c = 0 ; c < n; c++) {
            dfs(heights,m,n,0,c,-1,pacific,dir);
            dfs(heights,m,n,m-1,c,-1,alantic,dir);
        }

        for(int r = 0 ; r < m; r++) {
            dfs(heights,m,n,r,0,-1,pacific,dir);
            dfs(heights,m,n,r,n-1,-1,alantic,dir);
        }

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(pacific[r][c] && alantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r,c);
                    rs.add(cell);
                }
            }
        }
        return rs;
    }

    private void dfs(int[][] heights, int m, int n, int r, int c, int pre, boolean[][] ocean, int[][] dir) {
        if(r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }
        if(heights[r][c] < pre || ocean[r][c] == true) {
            return;
        }
        ocean[r][c] = true;
        for(int[] d : dir) {
            dfs(heights,m,n,r + d[0],c+d[1],heights[r][c],ocean,dir);
        }

    }

}