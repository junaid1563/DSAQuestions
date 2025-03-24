package stacknqueue;

import java.util.ArrayList;
import java.util.List;
/*
 * Approach
 * 
 * Take a list, at the time of insert, reverse it and then add x then again reverse it
 * this way last added value will go to start of list
 * Remove values from start(0 index)
*/

public class StackFromQueue {
    List<Integer> list;

    public StackFromQueue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        // List<Integer> l2 = new ArrayList<>();
        reverse(list);
        list.add(x);
        reverse(list);
    }

    public void reverse(List<Integer> list) {
        if (list.size() <= 1) {
            return;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    public int pop() {
        return list.remove(0);
    }

    public int top() {
        return list.get(0);
    }

    public boolean empty() {
        return list.size() == 0;
    }
}
