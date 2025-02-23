package strings;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is                    blue"));
    }

    public static String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
         for (int i = strs.length - 1; i > 0; i--) {

            sb.append(strs[i].trim() + " ");
        }
        sb.append(strs[0].trim());
        return sb.toString();
    }
}
