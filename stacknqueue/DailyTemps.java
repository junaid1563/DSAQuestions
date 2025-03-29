package stacknqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// https://leetcode.com/problems/daily-temperatures/
public class DailyTemps {
    public static void main(String[] args) {
        int[] tmps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] warmDays = dailyTemperatures(tmps);
        for (int warmDays2 : warmDays) {
            System.out.print(warmDays2 + " ");
        }

        System.out.println();
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        // final ans
        int[] warm = new int[temperatures.length];
        // stack to keep track of lower temperatures
        Stack<Integer> s = new Stack<>();
        // map to store indexes of lower and high temp values
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!s.isEmpty() && temp > temperatures[s.peek()]) {
                // if current temp is higher than last temp, add both indexes in map
                map.put(s.pop(), i);
            }
            // else add current index in stack
            s.push(i);
        }

        while (!s.isEmpty()) {
            // for indexes with no warm temps, add -1
            map.put(s.pop(), -1);
        }

        for (int i = 0; i < temperatures.length; i++) {
            int mapValue = map.getOrDefault(i, -1);
            if (mapValue == -1) {
                // if map value is -1, no warm temp . so add 0 in ans.
                warm[i] = 0;
            } else {
                // else add distance of i and map value
                warm[i] = mapValue - i;
            }
        }
        return warm;
    }
}
