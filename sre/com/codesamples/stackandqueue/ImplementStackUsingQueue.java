class MyStack {
    
    private ArrayDeque<Integer> queue1;
    
    public MyStack() {
        queue1 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue1.push(x);
        for(int i=0; i<queue1.size()-1; i++) {
            queue1.push(queue1.pop());
        }
    }

    public void pop() {
        queue1.pop();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
