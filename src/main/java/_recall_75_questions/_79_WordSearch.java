package _recall_75_questions;

public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int m = board.length;
        int n = board[0].length;
        for(int r = 0;  r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(existHelper(board,m,n,r,c,dir,word,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, int m, int n, int r, int c, int[][] dir, String word, int index) {
        if(index >= word.length()) {
            return true;
        }
        if(r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }
        if(board[r][c] == '_') {
            return false;
        }

        if(board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '_';
        boolean rs = false;
        for(int[] d : dir) {
            rs = rs || existHelper(board,m,n,r+d[0],c+d[1],dir,word,index+1);
            if(rs) {
                break;
            }
        }
        board[r][c] = temp;
        return rs;
    }
}