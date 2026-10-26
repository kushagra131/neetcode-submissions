class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min_stack;

    public MinStack() {
        stack = new ArrayDeque<>();
        min_stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty())
            min_stack.push(val);
        else if(val < min_stack.peek())
            min_stack.push(val);
        else
            min_stack.push(min_stack.peek());
    }
    
    public void pop() {
        stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
