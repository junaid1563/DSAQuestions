package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {
    
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        int majorityElement = 0, max=Integer.MIN_VALUE;
        Set<Entry<Integer, Integer>> set= map.entrySet();
        for(Entry<Integer, Integer> entry: set){
            if(entry.getValue()>max){
                majorityElement = entry.getKey();
                max = entry.getValue();
            }
        }
        return majorityElement;
    }

    public int majorityElement2(int[] nums) {
        int c = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (c == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    c = nums[i];
                } else {
                    count--;
                }
            }
        }
        return c;
    }
}
