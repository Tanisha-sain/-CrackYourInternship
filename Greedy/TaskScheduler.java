// You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. 
// Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: 
// identical tasks must be separated by at least n intervals due to cooling time.
// ​Return the minimum number of intervals required to complete all tasks.


class Solution {
    class Task{
        int time;
        int count;
        Task(int t, int c){
            this.time = t;
            this.count = c;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] freq = new int[26];
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task t1, Task t2){
                return Integer.compare(t2.count, t1.count);
            }
        });
        for(char task : tasks){
            freq[task - 'A']++;
        }
        for(int i = 0; i<26; i++){
            if(freq[i] > 0){
                pq.offer(new Task(0,freq[i]));
            }
        }
        Queue<Task> queue = new LinkedList<>();
        while(!pq.isEmpty() || !queue.isEmpty()){
            if(!queue.isEmpty() && (time - queue.peek().time) > n){
                pq.add(queue.remove());
            }
            if(!pq.isEmpty()){
                Task curr = pq.remove();
                curr.count--;
                curr.time = time;
                if(curr.count > 0){
                    queue.add(curr);
                }
            }
            time++;
        }
        return time;
    }
}
