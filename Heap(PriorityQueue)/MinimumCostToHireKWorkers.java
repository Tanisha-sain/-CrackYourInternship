// There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker
// and wage[i] is the minimum wage expectation for the ith worker.
// We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
// - Every worker in the paid group must be paid at least their minimum wage expectation.
// - In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double
// that of another worker in the group, then they must be paid twice as much as the other worker.
// Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions.
// Answers within 10-5 of the actual answer will be accepted.


class Solution {
    class Worker{
        double wageRate;
        int quality;
        Worker(double wageRate, int quality){
            this.wageRate = wageRate;
            this.quality = quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Worker> list = new ArrayList<>();
        for(int i = 0; i<quality.length; i++){
            double rate = 1.0*wage[i] / quality[i];
            list.add(new Worker(rate, quality[i]));
        }
        Collections.sort(list, (a,b) -> {
            if(a.wageRate >= b.wageRate) return 1;
            return -1;
        });

        PriorityQueue<Worker> pq = new PriorityQueue<>((a,b) -> b.quality - a.quality);
        double ans = Double.MAX_VALUE;
        int totalQuality = 0;
        for(int i = 0; i<quality.length; i++){
            pq.add(list.get(i));
            totalQuality += list.get(i).quality;
            if(pq.size() == k){
                ans = Math.min(ans, totalQuality*list.get(i).wageRate);
                totalQuality -= pq.poll().quality;
            }
        }
        return ans;
    }
}
