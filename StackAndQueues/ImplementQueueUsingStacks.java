// Implement a first in first out (FIFO) queue using only two stacks. 
// The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
  
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int data = stack2.peek();
        stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return data;
    }
    
    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int data = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return data;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}
