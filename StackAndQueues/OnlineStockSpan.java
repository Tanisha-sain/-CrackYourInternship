// Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
// The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
// for which the stock price was less than or equal to the price of that day.


class StockSpanner {
    static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
    Stack<Pair> stack;
    int ind;
    public StockSpanner() {
        stack = new Stack<>();
        ind = -1;
    }   
    public int next(int price) {
        ind++;
        while(!stack.isEmpty()){
            if(stack.peek().first <= price){
                stack.pop();
            }else{
                break;
            }
        }
        int ans = ind - (stack.isEmpty() ? -1 : stack.peek().second);
        stack.push(new Pair(price, ind));
        return ans;
    }
}
