// You are given a nested list of integers nestedList. Each element is either an integer or a list whose 
// elements may also be integers or other lists. Implement an iterator to flatten it.
// Implement the NestedIterator class:
// - NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
// - int next() Returns the next integer in the nested list.
// - boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.


public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        int size = nestedList.size();
        for(int i = size-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        int num = stack.pop().getInteger();
        return num;
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        while(!stack.isEmpty()){
            NestedInteger curr = stack.pop();
            if(curr.isInteger()){
                stack.push(curr);
                return true;
            }else{
                List<NestedInteger> list = curr.getList();
                int size = list.size();
                for(int i = size-1; i>=0; i--){
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}
