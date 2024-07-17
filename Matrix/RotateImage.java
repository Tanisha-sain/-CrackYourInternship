// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// [[1,2,3],          [[7,4,1],
//  [4,5,6],    =>     [8,5,2],                  
// [7,8,9]]            [9,6,3]]

class Solution {
    void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                swap(matrix,i,j);
            }
        }
        for(int[] row : matrix){
            int i = 0, j = m-1;
            while(i < j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }
}
