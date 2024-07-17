// Given an m x n matrix, return all elements of the matrix in spiral order.


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int sr = 0, sc = 0, er = n-1, ec = m-1;

        List<Integer> list = new ArrayList<>();
        while(sr <= er && sc <= ec){
            for(int i = sc; i<=ec; i++){
                list.add(matrix[sr][i]);
            }
            for(int i = sr+1; i<=er; i++){
                list.add(matrix[i][ec]);
            }
            for(int i = ec-1; i>=sc; i--){
                if(sr == er) break;
                list.add(matrix[er][i]);
            }
            for(int i = er-1; i>=sr+1; i--){
                if(sc == ec) break;
                list.add(matrix[i][sc]);
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
        return list;
    }
}
