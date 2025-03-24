package stacknqueue;

import java.util.Stack;

class QueueFromStack {
    // https://leetcode.com/problems/implement-queue-using-stacks/
    private Stack<Integer> s1;

    public QueueFromStack() {
        s1 = new Stack();
    }

    public void push(int x) {
        // everytime we need to push element, we first move all data to st
        // then we push x in st, this way st is last element is st
        // now we move back everything in s1 again, so now x is first element in s1
        Stack<Integer> st = new Stack<>();
        if (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                st.push(s1.pop());
            }
        }
        st.push(x);
        while(!st.isEmpty()){
            s1.push(st.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */