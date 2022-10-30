package binarysearch;

public class _74_Search_2D_Matrix {

        public boolean searchMatrix(int[][] matrix, int target) {
            int numberOfRow = matrix.length;
            int numberOfCol = matrix[0].length;

            if(matrix[0][0] > target || matrix[numberOfRow - 1][numberOfCol - 1] < target) {
                return false;
            }

            int foundedRowTarget = -1;

            for(int i = 0; i < numberOfRow; i++) {
                if(matrix[i][0] <= target && matrix[i][numberOfCol - 1] >= target) {
                    foundedRowTarget = i;
                }
            }

            if(foundedRowTarget == -1) {
                return false;
            }
            // TODO binary search
            for(int col = 0; col < numberOfCol; col++) {
                if(matrix[foundedRowTarget][col] == target) {
                    return true;
                }
            }
            return false;
        }

}
