package strings;

public class DecimalToRoman {
    // https://leetcode.com/problems/integer-to-roman/submissions/1551792912/
    // dont read rules, just add all numerals and their string values in array and iterate numeral array
    

    public static void main(String[] args) {
        System.out.println(intToRoman(1008));
    }
    public static String intToRoman(int num) {
        int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] strs = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        StringBuilder sb = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            while (num >= values[i]) {
                // subtract until we get num<values[i]
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
