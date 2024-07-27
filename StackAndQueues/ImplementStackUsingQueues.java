// Implement a last-in-first-out (LIFO) stack using only two queues. 
// The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        int data = -1;
        while(!queue1.isEmpty()){
            data = queue1.peek();
            queue2.offer(queue1.poll());
        }
        while(!queue2.isEmpty()){
            if(queue2.size() == 1){
                queue2.poll();
                break;
            }            
            queue1.offer(queue2.poll());
        }
        return data;
    }
    
    public int top() {
        int data = -1;
        while(!queue1.isEmpty()){
            data = queue1.peek();
            queue2.offer(queue1.poll());
        }
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return data;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}
