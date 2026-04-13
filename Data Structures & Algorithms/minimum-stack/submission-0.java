class MinStack {
    long minimum;
    Stack<Long> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            minimum = val;
        } else {
            stack.push(val - minimum);
            if(val < minimum)
                minimum = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        long pop = stack.pop();
        if(pop < 0)
            minimum = minimum - pop;
    }
    
    public int top() {
        long top = stack.peek();
        if(top > 0) {
            return (int) (top + minimum);
        } else {
            return (int) minimum;
        }
    }
    
    public int getMin() {
        return (int) minimum;
    }
}
