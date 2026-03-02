class MinStack {

    Stack<Integer> st1, min;
    public MinStack() {
        st1 = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        
        st1.push(val);

        if(min.isEmpty() || val <= min.peek())
        {
            min.push(val);
        }
        else
        {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        
        if(!st1.isEmpty())
        {
            st1.pop();
            min.pop();
        }
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {

        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */