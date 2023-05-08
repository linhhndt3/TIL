package _75_questions;

import java.util.*;

public class PacificAlanticWaterFlow_v1 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> rs = new ArrayList<>();
        Set<Cell> pacificReachable = new HashSet<>();
        Set<Cell> atlanticReachable = new HashSet<>();
        Set<Cell> setOfRs = new HashSet<>();
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {

            }
        }
        return rs;
    }

    private void pacificAtlanticHelper(int[][] heights, int m, int n, int r, int c,
                                       List<List<Integer>> rs , Set<Cell> pacificReachable, Set<Cell> atlanticReachable, Set<Cell> setOfRs) {
        if(r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }

        if(r == 0 || c == 0) {
            pacificReachable.add(new Cell(r,c));
        }
        if(r == m-1 || c == n-1) {
            atlanticReachable.add(new Cell(r,c));
        }
        int currentHeightOfCell = heights[m][n];
        if(r - 1 >= 0) {
            if(currentHeightOfCell >= heights[r+1][c]) {
                pacificAtlanticHelper(heights,m,n,r+1,c,rs,pacificReachable,atlanticReachable,setOfRs);
            }

        }
        if(r + 1 <= m-1) {
            if(currentHeightOfCell >= heights[r-1][c]) {
                pacificAtlanticHelper(heights,m,n,r-1,c,rs,pacificReachable,atlanticReachable,setOfRs);
            }

        }
        if(c - 1 >= 0) {
            if(currentHeightOfCell >= heights[r][c-1]) {
                pacificAtlanticHelper(heights,m,n,r,c-1,rs,pacificReachable,atlanticReachable,setOfRs);
            }

        }
        if(c + 1 <= n-1) {
            if(currentHeightOfCell >= heights[r][c+1]) {
                pacificAtlanticHelper(heights,m,n,r,c+1,rs,pacificReachable,atlanticReachable,setOfRs);
            }

        }

    }

    class Cell {
        int row;
        int col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cell)) return false;
            Cell cell = (Cell) o;
            return row == cell.row && col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}