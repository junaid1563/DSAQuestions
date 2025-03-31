package stacknqueue;

import java.util.*;

/*
 * Monotonic stack is either strictly incerasing or decreasing
 * here are common applications of monotonic stack
*/
public class MonotonicStack {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 9, 8, 2, 5, 10, 8, 3, 4 };
        int[] nextSmaller = nextSmaller(arr);
        System.out.println("Next Smaller");
        Arrays.stream(nextSmaller).forEach(next -> System.out.print(next + " "));
        System.out.println("\n Previous Smaller");
        int[] prevSmaller = previousSmaller(arr);
        Arrays.stream(prevSmaller).forEach(prev -> System.out.print(prev + " "));
        System.out.println("\n Next Larger");
        int[] nextLarger = nextLarger(arr);
        Arrays.stream(nextLarger).forEach(next -> System.out.print(next + " "));
        System.out.println("\n Previous Larger");
        int[] prevLarger = previousLarger(arr);
        Arrays.stream(prevLarger).forEach(prev -> System.out.print(prev + " "));
        System.out.println();
    }

    public static int[] nextSmaller(int[] arr) {
        // increasing stack
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = arr[stack.peek()];
            } else {
                ans[i] = -1;
            }

            stack.push(i);
        }
        return ans;
    }

    public static int[] previousSmaller(int[] arr) {
        // increasing stack
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= arr.length - 1; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = arr[stack.peek()];
            } else {
                ans[i] = -1;
            }

            stack.push(i);
        }
        return ans;
    }

    public static int[] nextLarger(int[] arr) {
        // decreasing stack
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = arr[stack.peek()];
            } else {
                ans[i] = -1;
            }

            stack.push(i);
        }
        return ans;
    }

    public static int[] previousLarger(int[] arr) {
        // decreasing stack
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= arr.length - 1; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = arr[stack.peek()];
            } else {
                ans[i] = -1;
            }

            stack.push(i);
        }
        return ans;
    }

}