package _recall_75_questions;

import java.util.LinkedList;
import java.util.List;

public class _417_PacificAtlanticOcean {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> rs = new LinkedList<>();
        int[][] dir = new int[][] {{0,1}, {0,-1}, {1,0},{-1,0}};
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int r = 0; r < m; r++) {
            visit(heights,m,n,r,0,-1,pacific,dir);
            visit(heights,m,n,r,n-1,-1,atlantic,dir);
        }

        for(int c = 0; c < n; c++) {
            visit(heights,m,n,0,c,-1,pacific,dir);
            visit(heights,m,n,m-1,c,-1,atlantic,dir);
        }

        return rs;
    }

    private void visit(int[][] heights, int m, int n, int r, int c, int pre, boolean[][] ocean, int[][] dir) {
        if(r < 0 || c < 0 || r >=m || c >= n) {
            return;
        }
        if(heights[r][c] < pre || ocean[r][c] == true) {
            return;
        }

        ocean[r][c] = true;
        for(int[] d: dir) {
            visit(heights,m,n,r+d[0],c+d[1],heights[r][c],ocean,dir);
        }
    }
}