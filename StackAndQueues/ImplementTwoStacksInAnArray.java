// Your task is to implement  2 stacks in one array efficiently. You need to implement 4 methods.
// twoStacks : Initialize the data structures and variables to be used to implement  2 stacks in one array.
// push1 : pushes element into first stack.
// push2 : pushes element into second stack.
// pop1 : pops element from first stack and returns the popped element. If first stack is empty, it should return -1.
// pop2 : pops element from second stack and returns the popped element. If second stack is empty, it should return -1.


class twoStacks {
    
    int[] arr;
    int top1, top2, n;
    twoStacks() {
        arr = new int[100];
        n = arr.length;
        top1 = -1;
        top2 = n;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if(top1 + 1 == top2) return;
        top1++;
        arr[top1] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if(top2-1 == top1) return;
        top2--;
        arr[top2] = x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(top1 == -1) return -1;
        int data = arr[top1];
        top1--;
        return data;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2 == n) return -1;
        int data = arr[top2];
        top2++;
        return data;
    }
}
