package strings;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/

public class AllDuplicates {

    public static void main(String[] args) {
        String str = "junaidisdumb";
        System.out.println(findAllDuplicates(str).toString());
    }
    public static Map<Character, Integer> findAllDuplicates(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.replace(ch, map.get(ch) + 1);
            }
        }
        return map;
    }
}
