// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals 
// you need to remove to make the rest of the intervals non-overlapping.

class Solution {
    class Data{
        int s;
        int e;
        Data(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Data[] in = new Data[n];
        int i = 0;
        for(int[] interval : intervals){
            in[i++] = new Data(interval[0], interval[1]);
        }
        Arrays.sort(in, (a,b) -> (a.e - b.e));

        int count = 1;
        int end = in[0].e;
        for(i = 1; i<n; i++){
            if(in[i].s >= end){
                count++;
                end = in[i].e;
            }
        }

        return n - count;

    }
}
