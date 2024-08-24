// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
// The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).


class Solution {
    class Temp{
        int x;
        int y;
        long dist;
        Temp(int x, int y, long dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Temp> pq = new PriorityQueue<>((a,b) -> (int)(a.dist - b.dist));
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            long dist = x*x + y*y;
            pq.add(new Temp(x,y,dist));
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i<k; i++){
            Temp curr = pq.poll();
            ans[i][0] = curr.x;
            ans[i][1] = curr.y;
        }
        return ans;
    }
}
