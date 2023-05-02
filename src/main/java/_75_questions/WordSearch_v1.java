package _75_questions;

public class WordSearch_v1 {

    public static void main(String[] args) {
        new WordSearch_v1().exist(new char[][]{{'l','l','a','l','l'},{'l','x','b','t','l'},{'a','b','c','b','a'},{'l','e','d','l','l'}},"abcdebxbt");
    }
    // TODO how the coding solution works? how recursively - map from solution to coding solution
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(existHelper(board, m, n, word,0, 2,4)) {
                    return true;
                }
                System.out.println(board);
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board, int m, int n, String word, int indexOfWord,int r, int c) {
        if(indexOfWord >= word.length()) {
            return true;
        }
        if(r < 0 || r >= m || c < 0 || c >= n ) {
            return false;
        }

        char currentCharacterOfBoard = board[r][c];

        if(currentCharacterOfBoard != word.charAt(indexOfWord)) {
            return false;
        }

        board[r][c] = 'x';
        boolean b1 = existHelper(board,m,n,word,indexOfWord+1,r+1,c);
        if(b1) {
            return b1;
        }
        boolean b2 = existHelper(board,m,n,word,indexOfWord+1,r,c+1);
        if(b2) {
            return b2;
        }
        boolean b3 = existHelper(board,m,n,word,indexOfWord+1,r-1,c);
        if(b3) {
            return b3;
        }
        boolean b4 = existHelper(board,m,n,word,indexOfWord+1,r,c-1);
        if(b4) {
            return b4;
        }

        board[r][c] = currentCharacterOfBoard;
        return b1 || b2 || b3 || b4;
    }

    private void printBoard(char[][] board, int m, int n) {
        for(int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(board[r][c]+' ');
            }
            System.out.println();
        }
    }
}