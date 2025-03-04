package maths;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// Not completed
public class MaxPoints {
    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int count = Integer.MIN_VALUE;
        int n = points.length;
        Map<Float, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                float slope = 0;
                if (x1 == x2 || y2 == y1) {
                    System.out.println("skipping,");
                    System.out
                            .println("p1 = " + x1 + ", " + y1 + " , p2 = " + x2 + " , " + y2);
                    continue;
                } else {

                    slope = (float) (y2 - y1) / (x2 - x1);
                    System.out
                            .println("p1 = " + x1 + ", " + y1 + " , p2 = " + x2 + " , " + y2 + " -- slope = " + slope);
                }

                if (map.containsKey(slope)) {
                    map.replace(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
            }
        }
        System.out.println("Slope map :" + map.toString());
        for (Entry<Float, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() > count) {
                count = entry.getValue();
            }
        }
        return count;
    }

}
