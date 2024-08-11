// Given a set of n jobs where each jobi has a deadline and profit associated with it.
// Each job takes 1 unit of time to complete and only one job can be scheduled at a time. 
// We earn the profit associated with a job if and only if the job is completed by its deadline.
// Find the number of jobs done and the maximum profit.
// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. 
// Deadline of the job is the time on or before which job needs to be completed to earn the profit.

class Solution{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n){
        // Your code here      
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        int[] hash = new int[n+1];
        Arrays.fill(hash, -1);
        int cnt = 0, profit = 0;
        for(int i = 0; i<n; i++){
            Job curr = arr[i];
            int counter = curr.deadline;
            while(counter > 0 && hash[counter] != -1){
                counter--;
            }
            if(counter > 0){
                hash[counter] = curr.id;
                profit += curr.profit;
                cnt++;
            }
        }
        int[] ans = new int[2];
        ans[0] = cnt;
        ans[1] = profit;
        return ans;
    }
}
