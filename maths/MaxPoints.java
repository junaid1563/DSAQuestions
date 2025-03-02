package maths;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// Not completed
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int count =1;
        int n = points.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int slope = 0;
                if (x1 == x2 || y2==y1) {
                    continue;
                }else{

                slope = y2 == y1 ? 0 : (y2 - y1) / (x2 - x1);
                }
                
                if ( map.containsKey(slope)) {
                    map.replace(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
            }
        }
        System.out.println(map.toString());
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey()!=-1  && entry.getValue() > count) {
                count = entry.getValue();
            }
        }
        return count;
    }

}
