import java.util.ArrayDeque;

class MyQueue {
    
    private ArrayDeque<Integer> stack1;
    private ArrayDeque<Integer> stack2;
    private int front;
    
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    public void pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()) {
            return front;
        }
        return stack2.peek();
    }

    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }
}
