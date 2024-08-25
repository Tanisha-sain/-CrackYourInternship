// Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

class Solution { 
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                maxHeap.offer(matrix[r][c]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
