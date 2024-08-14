// Given a 2D matrix matrix, handle multiple queries of the following type:
// Calculate the sum of the elements of matrix inside the rectangle defined by 
// its upper left corner (row1, col1) and lower right corner (row2, col2).
// Implement the NumMatrix class:
// - NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
// - int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix 
// inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
// - You must design an algorithm where sumRegion works on O(1) time complexity.


class NumMatrix {
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 1; j<m; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }   
        for(int i = 1; i<n; i++){
            for(int j = 0; j<m; j++){
                matrix[i][j] += matrix[i-1][j];
            }
        }
        prefixSum = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = col1 > 0 ? prefixSum[row2][col1-1] : 0;
        int b = row1 > 0 ? prefixSum[row1-1][col2] : 0;
        int c = row1 > 0 && col1 > 0 ? prefixSum[row1-1][col1-1] : 0;
        int sum = prefixSum[row2][col2] - a - b + c;
        return sum;
    }
}

